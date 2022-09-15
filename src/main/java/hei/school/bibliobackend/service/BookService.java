package hei.school.bibliobackend.service;


import hei.school.bibliobackend.model.Book;
import hei.school.bibliobackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    private Optional<Book> getBook(Integer idBook){
        return bookRepository.findById(idBook);
    }
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public void deleteBook(Integer idBook){
        bookRepository.deleteById(idBook);
    }
}
