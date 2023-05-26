package bookstore.controller.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @GetMapping
    public String logout(HttpSession session){
        session.removeAttribute("loggedUser"); //xóa tất cả các thuộc tính liên quan đến session hiện tại
        session.setAttribute("succMsg","Logout Sucessfully!");
        return "redirect:/login";
    }
}
