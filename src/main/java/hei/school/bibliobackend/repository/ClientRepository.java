package hei.school.bibliobackend.repository;

import hei.school.bibliobackend.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query("select c from Client c where upper(c.firstName) like upper(:x)")
    Page<Client> search(@Param("x") String s, Pageable pageable);
}
