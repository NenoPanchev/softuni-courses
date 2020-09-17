package studentSystem;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void addStudentIfNameNotPresent(Student student) {
        if (!existStudentWith(student.getName())) {
            repo.put(student.getName(), student);
        }
    }

    public void printDataOfStudentWith(String name) {
        if (existStudentWith(name)) {
            System.out.println(repo.get(name).studentData());
        }
    }

    private boolean existStudentWith(String name) {
        return repo.containsKey(name);
    }
}
