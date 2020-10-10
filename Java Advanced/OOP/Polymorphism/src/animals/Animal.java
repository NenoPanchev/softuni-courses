package animals;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood) {
        this.name = name;
        this.favouriteFood = favouriteFood;
    }

    protected String explainSelf() {
        return "I am " + this.name + " and my favourite food is " + this.favouriteFood;
    }

    public String getName() {
        return this.name;
    }

    public String getFavouriteFood() {
        return this.favouriteFood;
    }
}
