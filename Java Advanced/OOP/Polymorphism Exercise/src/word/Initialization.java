package word;

public abstract class Initialization {

    public static CommandImpl buildCommandInterface(StringBuilder text) {
        return new CommandImpl(text);
    }
}
