package hei.school.bibliobackend.repository;

import hei.school.bibliobackend.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
