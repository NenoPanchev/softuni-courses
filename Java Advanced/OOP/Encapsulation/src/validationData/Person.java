package validationData;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public double getSalary() {
            return this.salary;
        }

        public void setFirstName(String firstName) {
            if (firstName.length() < 3) {
                throw new IllegalArgumentException("First name cannot be less than 3 symbols");
            }
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            if (lastName.length() < 3) {
                throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
            }
            this.lastName = lastName;
        }

        public void setAge(int age) {
            if (age <= 0) {
                throw new IllegalArgumentException("Age cannot be zero or negative integer");
            }
            this.age = age;
        }

        public void setSalary(double salary) {
            if (salary < 460) {
                throw new IllegalArgumentException("Salary cannot be less than 460 leva");
            }
            this.salary = salary;
        }

    public Person(String firstName, String lastName, int age, double salary) throws IndexOutOfBoundsException {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setSalary(salary);
    }

        @Override
        public String toString() {
            return String.format("%s %s gets %s leva",
                    this.getFirstName(),
                    this.getLastName(),
                    this.getSalary());
        }

        public void increaseSalary(double percentBonus) {
            if (this.getAge() < 30) {
                percentBonus /= 2;
            }
            setSalary(this.getSalary() + this.getSalary() * percentBonus / 100);
        }
    }


