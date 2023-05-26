package bookstore.controller.user;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import bookstore.entity.User;
import bookstore.service.BookService;
import bookstore.service.UserService;

@Controller
@SessionAttributes("loggedUser")
public class CartController {

    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;
    @GetMapping("/cart")
    public String addCart(HttpSession session, @RequestParam Integer bid, @RequestParam Integer uid) {
        User user = userService.getUser(uid);
        user.addToCart(bookService.getBookById(bid));
        userService.updateUser(user);
        session.setAttribute("loggedUser", user);
        session.setAttribute("addCartSucc", "Cart Added Successfully!");
        System.out.println("added");
        return "redirect:/";
    }

    @GetMapping("/check_out")
    public String checkOutPage(@RequestParam Integer uid, Model model,HttpSession session) {
        User user = userService.getUser(uid);
        session.setAttribute("loggedUser", user);
        model.addAttribute("booksAdded", user.getBooks());
        model.addAttribute("total", user.totalCart());
        return "check_out";
    }

    @GetMapping("/remove_book")
    public String removeFromCart(@RequestParam Integer bid, @RequestParam Integer uid) {
        User user = userService.getUser(uid);
        user.removeFromCart(bookService.getBookById(bid));
        userService.updateUser(user);
        return "redirect:/check_out?uid=" + uid;
    }

}
