package hei.school.bibliobackend.controller;


import hei.school.bibliobackend.model.Book;
import hei.school.bibliobackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/book")
    public String getBook(Model model,
                          @RequestParam(name="bookSearch", defaultValue = "") String bookSearch,
                          @RequestParam(name="page", defaultValue= "0") Integer p,
                          @RequestParam(name="size", defaultValue= "5") Integer s){
        Page<Book> bookPage=
                bookRepository.search("%"+bookSearch+"%", PageRequest.of(p, s));
        model.addAttribute("listBook", bookPage.getContent());
        return "book";
    }

    @GetMapping  ("/addBook")
    public String putBook(Model model){
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/saveBook")
    public String saveBook(@Validated Book book){
        bookRepository.save(book);
        return "redirect:/book";
    }
}
