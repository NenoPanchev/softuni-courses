package facade;

public class Main {
    public static void main(String[] args) {
        Car car = new CarBuilderFacade()
                .info()
                .withType("BMW")
                .withColor("Black")
                .withNumberOfDoors(5)
                .built()
                .inCity("Leipzig")
                .atAddress("Some address 254")
                .build();

        Car car2 = new CarBuilderFacade()
                .info()
                .withColor("Green")
                .build();
        System.out.println(car2);
    }
}
