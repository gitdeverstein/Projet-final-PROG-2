package hei.school.bibliobackend.service;

import hei.school.bibliobackend.model.Client;
import hei.school.bibliobackend.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }
    private Optional<Client> getClient(Integer idClient){
        return clientRepository.findById(idClient);
    }
}
