package barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Fight extends Command {
    public Fight(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws NoSuchMethodException, IllegalAccessException, InstantiationException, ExecutionControl.NotImplementedException, InvocationTargetException, ClassNotFoundException {
        return "fight";
    }
}
