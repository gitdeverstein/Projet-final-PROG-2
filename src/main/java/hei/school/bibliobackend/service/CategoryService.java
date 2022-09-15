package hei.school.bibliobackend.service;


import hei.school.bibliobackend.model.Category;
import hei.school.bibliobackend.model.Client;
import hei.school.bibliobackend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    private Optional<Category> getClient(Integer idCategory){
        return categoryRepository.findById(idCategory);
    }
}
