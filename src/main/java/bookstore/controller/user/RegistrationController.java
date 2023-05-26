package bookstore.controller.user;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.dto.UserDto;
import bookstore.service.UserService;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "register";
    }

    @PostMapping("/register_user")
    public String registerSubmit(@Valid UserDto userDto,Model model, Errors errors) {

        if (errors.hasErrors()) {
            return "register";
        }
        else if (!userService.createUser(userDto)) {
            model.addAttribute("failedMsg", "Email already exists!");
            return "register";
        } else {
            model.addAttribute("succMsg", "Registration Successfully..");
            return "register";
        }

    }

}
