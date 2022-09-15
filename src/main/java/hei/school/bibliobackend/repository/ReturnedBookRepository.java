package hei.school.bibliobackend.repository;

import hei.school.bibliobackend.model.ReturnedBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReturnedBookRepository extends JpaRepository<ReturnedBook, Integer> {
    @Query("select d from ReturnedBook d where upper(d.title) like upper(:x)")
    Page<ReturnedBook> search(@Param("x") String s, Pageable pageable);
}
