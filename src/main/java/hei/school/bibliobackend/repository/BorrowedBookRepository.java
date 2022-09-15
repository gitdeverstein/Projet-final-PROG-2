package hei.school.bibliobackend.repository;

import hei.school.bibliobackend.model.BorrowedBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Integer> {
    @Query("select c from BorrowedBook c where upper(c.title) like upper(:x)")
    Page<BorrowedBook> search(@Param("x") String s, Pageable pageable);
}
