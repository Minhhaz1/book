package bookstore.controller.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    @GetMapping("/order")
    public String orderViewUser(HttpSession session){
        if(session.getAttribute("loggedUser")==null){
            return "login";
        }
        return "order";
    }
    @GetMapping("admin/order")
    public String orderViewAdmin(HttpSession session) {
        if (session.getAttribute("loggedUser") == null) {
            return "login";
        }
        return "admin_order";
    }
}
