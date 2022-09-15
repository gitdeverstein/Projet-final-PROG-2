package hei.school.bibliobackend.repository;

import hei.school.bibliobackend.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query("select b from Book b where upper(b.title) like upper(:x)")
    Page<Book> search(@Param("x") String s, Pageable pageable);
}
