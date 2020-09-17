package studentSystem;

public class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public String getName() {
        return this.name;
    }

    public String studentData() {
        return String.format("%s is %d years old. %s", this.name, this.age, createCommentaryBasedOnGrade());
    }

    private String createCommentaryBasedOnGrade() {
        if (this.grade >= 5.00) {
            return "Excellent student.";
        } else if (this.grade < 5.00 && this.grade >= 3.50) {
            return "Average student.";
        } else {
            return "Very nice person.";
        }
    }
}
