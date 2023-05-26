package bookstore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.entity.Book;
import bookstore.service.BookService;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public String home(Model model){
        model.addAttribute("books", bookService.getAllBook());
        return "index";
    }

}
