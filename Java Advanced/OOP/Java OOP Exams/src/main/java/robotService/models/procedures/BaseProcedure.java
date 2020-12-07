package robotService.models.procedures;

import robotService.common.ExceptionMessages;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.interfaces.Robot;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BaseProcedure implements Procedure {
    private Map<String, Robot> robots;

    protected BaseProcedure() {
        this.robots = new LinkedHashMap<>();
    }

    @Override
    public String history() {
        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName());
        for (Robot robot : this.robots.values()) {
            sb.append(System.lineSeparator()).append(robot.toString());
        }
        return sb.toString().trim();
    }

    @Override
    public void doService(Robot robot, int procedureTime) {
        if (robot.getProcedureTime() < procedureTime) {
            throw new IllegalArgumentException(ExceptionMessages.INSUFFICIENT_PROCEDURE_TIME);
        }
        doSpecificProcedureTask(robot);
        robot.setProcedureTime(robot.getProcedureTime() - procedureTime);
        this.robots.put(robot.getName(), robot);
    }

    protected Map<String, Robot> getRobots() {
        return this.robots;
    }

    protected void doSpecificProcedureTask(Robot robot) {

    }
}
