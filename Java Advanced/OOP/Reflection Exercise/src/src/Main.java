import interfaces.Repository;
import interfaces.Runnable;
import interfaces.UnitFactory;
import core.Engine;
import core.factories.UnitFactoryImpl;
import data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
