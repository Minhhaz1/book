package bookstore.controller.admin;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.entity.Book;
import bookstore.service.BookService;

@Controller
public class AddBookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/admin/add_books")
    public String addBookForm(Model model, HttpSession session) {
        if(session.getAttribute("loggedUser")==null){
            return "redirect:/login";
        }
        model.addAttribute("book", new Book());
        return "admin_add_books";
    }

    @PostMapping("/add_new_book")
    public String addBookSubmit(@Valid Book book,
                                Errors errors) {
        if (errors.hasErrors()) {
            return "admin_add_books";
        }
        bookService.addBook(book);
        return "redirect:admin/all_books";
    }
}
