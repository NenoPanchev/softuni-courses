package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>(this.capacity);
    }

    public int getCapacity() {
        return this.capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        for (Student st : this.students) {
            if (st.getFirstName().equals(student.getFirstName()) &&
                    st.getLastName().equals(student.getLastName())) {
                return "Student is already in the classroom";
            }
        }
        if (this.students.size() < this.capacity) {
            this.students.add(student);
            return "Added student " + student.getFirstName() + " " + student.getLastName();
        }

        return "No seats in the classroom";
    }

    public String dismissStudent(Student student) {
        for (Student st : this.students) {
            if (st.getFirstName().equals(student.getFirstName()) &&
                    st.getLastName().equals(student.getLastName())) {
                this.students.remove(st);
                return "Removed student " + student.getFirstName() + " " + student.getLastName();
            }
        }
        return "Student not found";
    }

    public String getSubjectInfo(String subject) {
//        List<Student> studentsWithThisSubject = this.students.stream()
//                .filter(student -> student.getBestSubject().equals(subject))
//                .collect(Collectors.toList());
        List<Student> studentsWithThisSubject = new ArrayList<>();
        for (Student student : this.students) {
            if (student.getBestSubject().equals(subject)) {
                studentsWithThisSubject.add(student);
            }
        }
        if (!studentsWithThisSubject.isEmpty()) {
            StringBuilder sb = new StringBuilder(String.format("Subject: %s%nStudents:%n", subject));
            studentsWithThisSubject.forEach(student -> sb.append(student.getFirstName())
            .append(" ").append(student.getLastName()).append(System.lineSeparator()));
            return sb.toString().trim();
        }
        return "No students enrolled for the subject";
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream()
                .filter(student -> student.getFirstName().equals(firstName) &&
                        student.getLastName().equals(lastName))
                .findFirst()
                .orElse(null);
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder(String.format("Classroom size: %d%n", this.students.size()));
        this.students.forEach(student -> sb.append("==").append(student).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
