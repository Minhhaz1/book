package bookstore.controller.user;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import bookstore.dto.UserDto;
import bookstore.entity.User;
import bookstore.service.UserService;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginForm(Model model,HttpSession session) {
        model.addAttribute("user", new UserDto());
        return "login";
    }

    @PostMapping
    public String homePage(@ModelAttribute("user") UserDto userDto, Errors errors, Model model,HttpSession session) {
        if (errors.hasErrors()) {
            return "login";
        }
        User user = userService.login(userDto);
        if (user != null) {
            session.setAttribute("loggedUser", user);
            if (user.getRole().equals("ADMIN")) {
                return "redirect:/admin/home";
            } else {
                return "redirect:/";
            }
        } else {
            model.addAttribute("failedMsg","Email and Password Invalid!");
            return "login";
        }
    }
}
