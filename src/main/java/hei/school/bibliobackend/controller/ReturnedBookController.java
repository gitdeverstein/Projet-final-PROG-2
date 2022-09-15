package hei.school.bibliobackend.controller;


import hei.school.bibliobackend.model.ReturnedBook;
import hei.school.bibliobackend.repository.ReturnedBookRepository;
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
public class ReturnedBookController {
    @Autowired
    private ReturnedBookRepository returnedBookRepository;

    @GetMapping("/returnedBook")
    public String getReturnedBook(Model model,
                                  @RequestParam(name="returnedBookSearch", defaultValue = "") String returnedBookSearch,
                                  @RequestParam(name="page", defaultValue= "0") Integer p,
                                  @RequestParam(name="size", defaultValue= "5") Integer s){
        Page<hei.school.bibliobackend.model.ReturnedBook> returnedBookPage=
                returnedBookRepository.search("%"+returnedBookSearch+"%", PageRequest.of(p, s));
        model.addAttribute("listReturnedBook", returnedBookPage.getContent());
        return "returnedBook";
    }

    @GetMapping  ("/addReturnedBook")
    public String putReturnedBook(Model model){
        model.addAttribute("returnedBook", new ReturnedBook());
        return "addReturnedBook";
    }

    @PostMapping("/saveReturnedBook")
    public String saveReturnedBook(@Validated hei.school.bibliobackend.model.ReturnedBook returnedBook){
        returnedBookRepository.save(returnedBook);
        return "redirect:/returnedBook";
    }
}
