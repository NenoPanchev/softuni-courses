package onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.Product;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public double getOverallPerformance() {
        if (this.components.isEmpty()) {
            return super.getOverallPerformance();
        } else {
            return super.getOverallPerformance() + this.components.stream()
                    .mapToDouble(Component::getOverallPerformance)
                    .average()
                    .orElse(0.00);
        }
    }

    @Override
    public double getPrice() {
        return super.getPrice()
                + this.components.stream()
                    .mapToDouble(Component::getPrice)
                    .sum()
                + this.peripherals.stream()
                    .mapToDouble(Peripheral::getPrice)
                    .sum();
    }

    @Override
    public void addComponent(Component component) {
        for (Component component1 : this.components) {
            if (component1.getClass().getSimpleName().equals(component.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                        component.getClass().getSimpleName(),
                        this.getClass().getSimpleName(),
                        this.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
        if (!this.components.isEmpty()) {
            for (Component component : this.components) {
                if (component.getClass().getSimpleName().equals(componentType)) {
                    this.components.remove(component);
                    return component;
                }
            }
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_COMPONENT,
                componentType,
                this.getClass().getSimpleName(),
                this.getId()));
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        for (Peripheral peripheral1 : this.peripherals) {
            if (peripheral1.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName())) {
                throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_PERIPHERAL,
                        peripheral.getClass().getSimpleName(),
                        this.getClass().getSimpleName(),
                        this.getId()));
            }
        }
        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (!this.peripherals.isEmpty()) {
            for (Peripheral peripheral : this.peripherals) {
                if (peripheral.getClass().getSimpleName().equals(peripheralType)) {
                    this.peripherals.remove(peripheral);
                    return peripheral;
                }
            }
        }
        throw new IllegalArgumentException(String.format(ExceptionMessages.NOT_EXISTING_PERIPHERAL,
                peripheralType,
                this.getClass().getSimpleName(),
                this.getId()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(OutputMessages.PRODUCT_TO_STRING,
                this.getOverallPerformance(),
                this.getPrice(),
                this.getClass().getSimpleName(),
                this.getManufacturer(),
                this.getModel(),
                this.getId()));
        sb.append(System.lineSeparator()).append(" ").append(String.format(OutputMessages.COMPUTER_COMPONENTS_TO_STRING, this.components.size()));

        for (Component component : this.components) {
            sb.append(System.lineSeparator()).append("  ").append(component);
        }

        sb.append(System.lineSeparator()).append(" ").append(String.format(OutputMessages.COMPUTER_PERIPHERALS_TO_STRING,
                this.peripherals.size(),
                peripherals.stream()
                        .mapToDouble(Product::getOverallPerformance)
                        .average()
                        .orElse(0.00)));

        for (Peripheral peripheral : this.peripherals) {
            sb.append(System.lineSeparator()).append("  ").append(peripheral);
        }

        return sb.toString().trim();
    }
}
