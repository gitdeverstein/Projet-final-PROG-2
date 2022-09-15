package hei.school.bibliobackend.controller;

import hei.school.bibliobackend.model.BorrowedBook;
import hei.school.bibliobackend.repository.BorrowedBookRepository;
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
public class BorrowedBookController {
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @GetMapping("/borrowedBook")
    public String getBorrowedBook(Model model,
                          @RequestParam(name="borrowedBookSearch", defaultValue = "") String borrowedBookSearch,
                          @RequestParam(name="page", defaultValue= "0") Integer p,
                          @RequestParam(name="size", defaultValue= "5") Integer s){
        Page<BorrowedBook> borrowedBookPage=
                borrowedBookRepository.search("%"+borrowedBookSearch+"%", PageRequest.of(p, s));
        model.addAttribute("listBorrowedBook", borrowedBookPage.getContent());
        return "borrowedBook";
    }

    @GetMapping  ("/addBorrowedBook")
    public String putBorrowedBook(Model model){
        model.addAttribute("borrowedBook", new BorrowedBook());
        return "addBorrowedBook";
    }

    @PostMapping("/saveBorrowedBook")
    public String saveBorrowedBook(@Validated BorrowedBook borrowedBook){
        borrowedBookRepository.save(borrowedBook);
        return "redirect:/borrowedBook";
    }
}
