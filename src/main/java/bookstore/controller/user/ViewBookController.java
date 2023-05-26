package bookstore.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.service.BookService;

import java.awt.print.Book;

@Controller
public class ViewBookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/view_book")
    public String bookDetails(Model model, @RequestParam Integer bid) {
        model.addAttribute("book", bookService.getBookById(bid));
        return "view_book";
    }

}
