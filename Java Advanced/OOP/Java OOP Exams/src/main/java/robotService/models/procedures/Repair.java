package robotService.models.procedures;

import robotService.common.ExceptionMessages;
import robotService.models.robots.interfaces.Robot;

public class Repair extends BaseProcedure {

    @Override
    protected void doSpecificProcedureTask(Robot robot) {
        robot.setHappiness(robot.getHappiness() - 5);
        if (robot.isRepaired()) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.ALREADY_REPAIRED, robot.getName()));
        }
        robot.setRepaired(true);
    }
}
