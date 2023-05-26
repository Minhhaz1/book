package bookstore.controller.admin;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bookstore.service.BookService;

@Controller
@RequestMapping("/admin/all_books")
public class DisplayBookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public String displayAllBooks(Model model, HttpSession session){
        if(session.getAttribute("loggedUser")==null){
            return "redirect:/login";
        }else {
            model.addAttribute("books", bookService.getAllBooksOrderByIdDesc());
            return "admin_all_books";
        }
    }
}
