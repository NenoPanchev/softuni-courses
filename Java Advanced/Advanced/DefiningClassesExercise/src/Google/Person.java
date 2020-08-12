package Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    Car car;
    List<Pokemon> pokemonList;
    List<Parent> parentsList;
    List<Child> children;

    Person(String name) {
        this.name = name;
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    Person() {
        this.pokemonList = new ArrayList<>();
        this.parentsList = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public Car getCar() {
        return car;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public List<Parent> getParentsList() {
        return parentsList;
    }

    public List<Child> getChildren() {
        return children;
    }
}
