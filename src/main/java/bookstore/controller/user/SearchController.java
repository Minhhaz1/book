package bookstore.controller.user;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.service.BookService;

@Controller
public class SearchController {
    @Autowired
    private BookService bookService;
    @PostMapping("/search_books")
    public String submitForm(HttpServletRequest request, Model model) {
        String keyword = request.getParameter("search");
        model.addAttribute("books", bookService.getBooksBySearching(keyword,keyword));
        model.addAttribute("keyword",keyword);
        return "search_books";
    }
}
