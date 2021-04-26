package exams.gira.web;

import exams.gira.model.binding.TaskAddBindingModel;
import exams.gira.model.service.TaskServiceModel;
import exams.gira.model.service.UserServiceModel;
import exams.gira.service.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;
    private final ModelMapper modelMapper;

    @Autowired
    public TasksController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("taskAddBindingModel")) {
            model.addAttribute("taskAddBindingModel", new TaskAddBindingModel());
        }
        return "add-task";
    }

    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("taskAddBindingModel")TaskAddBindingModel taskAddBindingModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes,
                             HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("taskAddBindingModel", taskAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.taskAddBindingModel", bindingResult);
            return "redirect:add";
        } else {
            this.taskService
                    .addTask(this.modelMapper.map(taskAddBindingModel, TaskServiceModel.class), (UserServiceModel) httpSession.getAttribute("user"));
            return "redirect:/";
        }
    }
}
