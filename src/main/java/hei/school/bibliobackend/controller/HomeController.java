package hei.school.bibliobackend.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class HomeController {
    @GetMapping
    public String getHome(){
        return "index";
    }
}
