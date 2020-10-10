package animals;

public class Cat extends Animal {

    protected Cat(String name, String favouriteFood) {
        super(name, favouriteFood);
    }

    @Override
    protected String explainSelf() {
        return super.explainSelf() + System.lineSeparator() + "MEEOW";
    }
}
