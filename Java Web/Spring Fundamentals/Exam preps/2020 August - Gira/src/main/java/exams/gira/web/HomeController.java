package exams.gira.web;

import exams.gira.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final TaskService taskService;

    @Autowired
    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession httpSession, ModelAndView modelAndView) {
        if (httpSession.getAttribute("user") == null) {
            modelAndView.setViewName("index");
        } else {
            modelAndView.addObject("tasks", this.taskService.getAllTasks());
            modelAndView.setViewName("home");
        }

        return modelAndView;
    }

    @GetMapping("/progress/{id}")
    public String progress(@PathVariable("id") String id) {
        this.taskService.progress(id);
        return "redirect:/";
    }
}
