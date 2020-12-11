package oldCounterStriker;

import oldCounterStriker.core.EngineImpl;
import oldCounterStriker.core.Engine;

public class Main {
    public static void main(String[] args) {
        Engine engine = new EngineImpl();
        engine.run();
    }
}
