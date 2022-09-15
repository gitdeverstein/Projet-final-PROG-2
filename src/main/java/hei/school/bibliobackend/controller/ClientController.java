package hei.school.bibliobackend.controller;

import hei.school.bibliobackend.model.Client;
import hei.school.bibliobackend.repository.ClientRepository;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/client")
    public String getClient(Model model,
                            @RequestParam(name="clientSearch", defaultValue= "") String clientSearch,
                            @RequestParam(name="page", defaultValue= "0") Integer p,
                            @RequestParam(name="size", defaultValue= "5") Integer s){
        Page<Client> clientPage=
                clientRepository.search("%"+clientSearch+"%", PageRequest.of(p, s));
        model.addAttribute("listClient", clientPage.getContent());
        return "client";
    }

    @GetMapping("/addClient")
    public String putClient(Model model){
        model.addAttribute("client", new Client());
        return "addClient";
    }

    @PostMapping("/saveClient")
    public String saveClient(@Validated Client client){
        clientRepository.save(client);
        return "redirect:/client";
    }
}
