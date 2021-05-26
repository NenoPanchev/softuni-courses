package spring.cloudinary.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import spring.cloudinary.model.service.StudentServiceModel;
import spring.cloudinary.service.StudentService;

import java.io.IOException;

@Controller
public class HomeController {

    private final StudentService studentService;

    public HomeController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public String add(Model model,  @ModelAttribute("studentServiceModel")
            StudentServiceModel studentServiceModel) throws IOException {

        this.studentService.addStudent(studentServiceModel);
        model.addAttribute("students", this.studentService.findAll());
        return "home";
    }
}
