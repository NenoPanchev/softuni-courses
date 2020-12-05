package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {
    private List<Computer> computers;
    private List<Component> components;
    private List<Peripheral> peripherals;

    public ControllerImpl() {
        this.computers = new ArrayList<>();
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }


    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        for (Computer computer : this.computers) {
            if (computer.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
            }
        }
        Computer computer;

        switch (computerType) {
            case "DesktopComputer":
                computer = new DesktopComputer(id, manufacturer, model, price);
                break;

            case "Laptop":
                computer = new Laptop(id, manufacturer, model, price);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
        }
        this.computers.add(computer);
        return String.format(OutputMessages.ADDED_COMPUTER, computer.getId());
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        checksIfComputerWithGivenIdExistsOrThrows(computerId);

        for (Peripheral peripheral : this.peripherals) {
            if (peripheral.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
            }
        }

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;

            case "Keyboard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;

            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;

            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        this.peripherals.add(peripheral);
        this.computers.stream()
                .filter(computer -> computer.getId() == computerId)
                .findFirst()
                .orElse(null)
                .addPeripheral(peripheral);

        return String.format(OutputMessages.ADDED_PERIPHERAL,
                peripheralType,
                id,
                computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        checksIfComputerWithGivenIdExistsOrThrows(computerId);

        Peripheral peripheralToRemove = null;
        for (Peripheral peripheral : this.peripherals) {
            if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                peripheralToRemove = peripheral;
            }
        }
        this.peripherals.remove(peripheralToRemove);
        this.computers.stream()
                .filter(computer -> computer.getId() == computerId)
                .findFirst()
                .orElse(null)
                .removePeripheral(peripheralType);

        return String.format(OutputMessages.REMOVED_PERIPHERAL,
                peripheralType,
                peripheralToRemove.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        checksIfComputerWithGivenIdExistsOrThrows(computerId);
        for (Component component : this.components) {
            if (component.getId() == id) {
                throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPONENT_ID);
            }
        }
        Component component;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;

            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;

            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;

            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;

            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;

            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;

            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);
        }

        this.components.add(component);
        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                computer.addComponent(component);
            }
        }
        return String.format(OutputMessages.ADDED_COMPONENT,
                componentType,
                id,
                computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        checksIfComputerWithGivenIdExistsOrThrows(computerId);
        Component componentToRemove = null;
        for (Component component : this.components) {
            if (component.getClass().getSimpleName().equals(componentType)) {
                componentToRemove = component;
            }
        }
        this.components.remove(componentToRemove);
        this.computers.stream()
                .filter(computer -> computer.getId() == computerId)
                .findFirst()
                .orElse(null)
        .removeComponent(componentType);

        return String.format(OutputMessages.REMOVED_COMPONENT,
                componentType,
                componentToRemove.getId());
    }

    @Override
    public String buyComputer(int id) {
        checksIfComputerWithGivenIdExistsOrThrows(id);
        Computer computerToRemove = null;
        for (Computer computer : this.computers) {
            if (computer.getId() == id) {
                computerToRemove = computer;
            }
        }
        this.computers.remove(computerToRemove);
        return computerToRemove.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        Computer computerToReturn = this.computers.stream()
                .filter(computer -> computer.getPrice() <= budget)
                .sorted((a, b) -> Double.compare(b.getOverallPerformance(), a.getOverallPerformance()))
                .findFirst()
                .orElse(null);

        if (computerToReturn == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER,
                    budget));
        }
        return computerToReturn.toString();
    }

    @Override
    public String getComputerData(int id) {
        checksIfComputerWithGivenIdExistsOrThrows(id);
        return this.computers.stream()
                .filter(computer -> computer.getId() == id)
                .findFirst()
                .orElse(null)
                .toString();
    }

    private void checksIfComputerWithGivenIdExistsOrThrows(int computerId) {
        for (Computer computer : this.computers) {
            if (computer.getId() == computerId) {
                return;
            }
        }
        throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
    }
}
