package hei.school.bibliobackend.service;

import hei.school.bibliobackend.repository.ReturnedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ReturnedBook {
    @Autowired
    private ReturnedBookRepository returnedBookRepository;

    public List<hei.school.bibliobackend.model.ReturnedBook> getAllReturnedBook(){
        return returnedBookRepository.findAll();
    }
    private Optional<hei.school.bibliobackend.model.ReturnedBook> getReturnedBook(Integer idReturnedBook){
        return returnedBookRepository.findById(idReturnedBook);
    }
    public hei.school.bibliobackend.model.ReturnedBook addReturnedBook(hei.school.bibliobackend.model.ReturnedBook returnedBook){
        return returnedBookRepository.save(returnedBook);
    }
    public void deleteReturnedBook(Integer idReturnedBook){
        returnedBookRepository.deleteById(idReturnedBook);
    }
}
