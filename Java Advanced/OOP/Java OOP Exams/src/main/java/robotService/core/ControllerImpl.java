package robotService.core;

import robotService.common.ExceptionMessages;
import robotService.common.OutputMessages;
import robotService.core.interfaces.Controller;
import robotService.models.garages.GarageImpl;
import robotService.models.garages.interfaces.Garage;
import robotService.models.procedures.Charge;
import robotService.models.procedures.Repair;
import robotService.models.procedures.Work;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.robots.Cleaner;
import robotService.models.robots.Housekeeper;
import robotService.models.robots.interfaces.Robot;

public class ControllerImpl implements Controller {
    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy, int happiness, int procedureTime) {
        Robot robot;
        switch (robotType) {
            case "Housekeeper":
                robot = new Housekeeper(name, happiness, energy, procedureTime);
                break;
            case "Cleaner":
                robot = new Cleaner(name, happiness, energy, procedureTime);
                break;
            default:
                throw new IllegalArgumentException(String.format(
                        ExceptionMessages.INVALID_ROBOT_TYPE, robotType));
        }
        this.garage.manufacture(robot);

        return String.format(OutputMessages.ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {
        checkForRobotWithName(robotName);
        this.repair.doService(this.garage.getRobots().get(robotName), procedureTime);
        return String.format(OutputMessages.REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        checkForRobotWithName(robotName);
        this.work.doService(this.garage.getRobots().get(robotName), procedureTime);
        return String.format(OutputMessages.WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        checkForRobotWithName(robotName);
        this.charge.doService(this.garage.getRobots().get(robotName), procedureTime);
        return String.format(OutputMessages.CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        checkForRobotWithName(robotName);
        this.garage.sell(robotName, ownerName);
        return String.format(OutputMessages.SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        switch (procedureType) {
            case "Repair":
                return this.repair.history();

            case "Work":
                return this.work.history();

            default:
                return this.charge.history();
        }
    }

    private void checkForRobotWithName(String name) {
        if (!this.garage.getRobots().containsKey(name)) {
            throw new IllegalArgumentException(String.format(
                    ExceptionMessages.NON_EXISTING_ROBOT, name));
        }
    }
}
