package hei.school.bibliobackend.repository;

import hei.school.bibliobackend.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, String> {
}
