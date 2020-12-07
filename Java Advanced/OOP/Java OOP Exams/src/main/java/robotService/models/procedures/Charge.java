package robotService.models.procedures;

import robotService.models.robots.interfaces.Robot;

public class Charge extends BaseProcedure {
    @Override
    protected void doSpecificProcedureTask(Robot robot) {
        robot.setHappiness(robot.getHappiness() + 12);
        robot.setEnergy(robot.getEnergy() + 10);
    }
}
