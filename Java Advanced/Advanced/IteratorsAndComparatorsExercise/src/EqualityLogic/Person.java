package EqualityLogic;

public class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getAge();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (Person.class.getSimpleName().equals(other.getClass().getSimpleName())) {
            Person second = (Person) other;
            return this.getName().equals(second.getName()) && this.getAge() == second.getAge();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return (this.getName().hashCode() + this.getAge()) * 73;
    }

    @Override
    public int compareTo(Person other) {
        int sort = this.getName().compareTo(other.getName());
        if (sort == 0) {
            sort = this.getAge() - other.getAge();
        }
        return sort;
    }
}
