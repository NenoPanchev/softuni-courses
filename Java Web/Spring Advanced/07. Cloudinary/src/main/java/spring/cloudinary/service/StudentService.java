package spring.cloudinary.service;

import spring.cloudinary.model.service.StudentServiceModel;
import spring.cloudinary.model.view.StudentViewModel;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    void addStudent(StudentServiceModel studentServiceModel) throws IOException;

    List<StudentViewModel> findAll();
}
