package bookstore.controller.admin;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    @GetMapping("/home")
    public String adminHomePage(HttpSession session){
        if(session.getAttribute("loggedUser") == null){
            return "login";
        }
        return "admin_home";
    }
}
