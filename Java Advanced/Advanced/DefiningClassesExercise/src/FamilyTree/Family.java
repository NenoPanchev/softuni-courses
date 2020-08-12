package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Family {
    Person person;
    List<Person> parents;
    List<Person> children;

    Family(){
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    Family(Person person) {
        this.person = person;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(String.format("%s %s%n", this.getPerson().getName(), this.getPerson().getDate()));
        print.append("Parents:\n");
        for (Person parent : this.getParents()) {
            print.append(parent.getName() + " " + parent.getDate() + "\n");
        }
        print.append("Children:\n");
        for (Person child : this.getChildren()) {
            print.append(child.getName() + " " + child.getDate() + "\n");
        }
        return print.toString();
    }
}
