package bookstore.controller.admin;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import bookstore.entity.Book;
import bookstore.service.BookService;

@Controller
@Transactional
public class UpdateBookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/edit_book/{id}")
    public String editBookForm(@PathVariable Integer id, Model model,HttpSession session) {
        if(session.getAttribute("loggedUser")==null){
            return "redirect:/login";
        }else {
            Book book = bookService.getBookById(id);
            model.addAttribute("book", book);
            return "admin_edit_book";
        }
    }

    @PostMapping("/sedit_book")
    public String updateEditedBook(@Valid Book book,
                                    Errors errors, HttpSession session) {
        if (errors.hasErrors()) {
            return "admin_edit_book";
        }
        session.setAttribute("succMsg", "Book Update Sucessfully!");
        bookService.updateBook(book);
        return "redirect:/admin/all_books";
    }
    @GetMapping("/delete_book/{id}")
    public String deleteBook(@PathVariable Integer id,HttpSession session){
        if(session.getAttribute("loggedUser")==null){
            return "redirect:/login";
        }
        bookService.deleteBookById(id);
        return "redirect:/admin/all_books";
    }

}
