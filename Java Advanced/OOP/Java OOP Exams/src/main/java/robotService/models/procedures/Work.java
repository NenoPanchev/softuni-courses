package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Work extends BaseProcedure {

    @Override
    protected void doSpecificProcedureTask(Robot robot) {
        robot.setEnergy(robot.getEnergy() - 6);
        robot.setHappiness(robot.getHappiness() + 12);
    }
}
