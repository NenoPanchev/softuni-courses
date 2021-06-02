package spring.softunimusicdb.web;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.softunimusicdb.model.binding.UserRegistrationBindingModel;
import spring.softunimusicdb.model.entities.UserEntity;
import spring.softunimusicdb.model.service.UserRegistrationServiceModel;
import spring.softunimusicdb.service.UserService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute("registrationBindingModel")
    public UserRegistrationBindingModel createBindingModel() {
        return new UserRegistrationBindingModel();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerAndLoginUser(@Valid UserRegistrationBindingModel registrationBindingModel,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationBindingModel", bindingResult);

            return "redirect:register";
        }

        if (this.userService.usernameExists(registrationBindingModel.getUsername())) {
            redirectAttributes.addFlashAttribute("userExistsError", true);
            redirectAttributes.addFlashAttribute("registrationBindingModel", registrationBindingModel);
            return "redirect:register";
        }

        UserRegistrationServiceModel userServiceModel = modelMapper
                .map(registrationBindingModel, UserRegistrationServiceModel.class);
        userService.registerAndLoginUser(userServiceModel);
        return "redirect:/home";
    }

    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
                                    RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("bad_credentials", true);
        redirectAttributes.addFlashAttribute("username", username);

        return "redirect:login";
    }

    @GetMapping("/update")
    public String update(Principal principal, Model model) {
        UserEntity userEntity = userService.findByUsername(principal.getName());

        model.addAttribute("username", userEntity.getUsername());
        model.addAttribute("userId", userEntity.getId());
        return "update";
    }

    @PatchMapping( "/update/{id}")
    public String updateConfirm(@PathVariable Long id) {
        System.out.println();
//        userService.updateUser(id, username);
        return "redirect:/home";
    }
}
