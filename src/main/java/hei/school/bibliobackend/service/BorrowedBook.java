package hei.school.bibliobackend.service;

import hei.school.bibliobackend.repository.BorrowedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowedBook {
    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    public List<hei.school.bibliobackend.model.BorrowedBook> getAllBorrowedBook(){
        return borrowedBookRepository.findAll();
    }
    private Optional<hei.school.bibliobackend.model.BorrowedBook> getBorrowedBook(Integer idBorrowedBook){
        return borrowedBookRepository.findById(idBorrowedBook);
    }
    public hei.school.bibliobackend.model.BorrowedBook addBorrowedBook(hei.school.bibliobackend.model.BorrowedBook borrowedBook){
        return borrowedBookRepository.save(borrowedBook);
    }
    public void deleteBook(Integer idBorrowedBook){
        borrowedBookRepository.deleteById(idBorrowedBook);
    }
}
