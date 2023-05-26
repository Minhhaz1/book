package bookstore.controller.user;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import bookstore.entity.User;
import bookstore.service.UserService;

@Controller
@SessionAttributes("loggedUser")
public class EditProfileController {
    @Autowired
    private UserService userService;
    @GetMapping("/edit_profile")
    public String profile(HttpSession session){
        if(session.getAttribute("loggedUser")==null){
            return "redirect:/login";
        }
        return "edit_profile";
    }
    @PostMapping("/update_user")
    public String updateUser(@ModelAttribute("loggedUser") User user){
        userService.updateUser(user);
        return "redirect:/setting";
    }
}
