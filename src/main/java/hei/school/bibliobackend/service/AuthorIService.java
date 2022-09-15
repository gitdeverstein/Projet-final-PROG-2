package hei.school.bibliobackend.service;


import hei.school.bibliobackend.model.Author;
import hei.school.bibliobackend.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorIService {
  @Autowired
  private AuthorRepository authorRepository;

  public List<Author> getAllAuthor(){
    return authorRepository.findAll();
  }
}
