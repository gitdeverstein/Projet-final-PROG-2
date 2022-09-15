package hei.school.bibliobackend;

import hei.school.bibliobackend.model.*;
import hei.school.bibliobackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BiblioBackendApplication implements CommandLineRunner {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BorrowedBookRepository borrowedBookRepository;

    @Autowired
    private ReturnedBookRepository returnedBookRepository;

    public static void main(String[] args) {
        SpringApplication.run(BiblioBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        clientRepository.save(new Client(1, "Johnson", "Mike"));
        clientRepository.save(new Client(2, "Wintheiser", "Sophia"));
        clientRepository.save(new Client(3, "Kertzmann", "Madie"));

        authorRepository.save(new Author(1, "Wilkinson"));
        authorRepository.save(new Author(2, "Hegmann"));
        authorRepository.save(new Author(3, "Reilly"));

        categoryRepository.save( new Category(1, "Horror"));
        categoryRepository.save( new Category(2, "Scifi"));
        categoryRepository.save( new Category(3, "Adventure"));

        bookRepository.save(new Book(1, "Harry Potter", "Wilkinson", "Horror", "buzzing-terrorism"));
        bookRepository.save(new Book(2, "The siren", "Hegmann", "Scifi", "buzzing-terrorism"));
        bookRepository.save(new Book(3, "Merlin", "Reilly", "Adventure", "prudent-test"));

        borrowedBookRepository.save(new BorrowedBook(1, "Harry Potter", "Larry", "Johnson", "08/02/2022"));
        borrowedBookRepository.save(new BorrowedBook(2, "L'or noir", "Carter", "Jack", "13/04/2021"));
        borrowedBookRepository.save(new BorrowedBook(3, "Oui Oui", "Wintheiser", "Aliya", "26/04/2022"));

        returnedBookRepository.save(new ReturnedBook(1,"La Terre", "Ondricka", "Florine", "04/08/2022"));
        returnedBookRepository.save(new ReturnedBook(2,"La forêt enchantée", "Hilpert", "Alan", "18/07/2022"));
        returnedBookRepository.save(new ReturnedBook(3,"Le seidneur des anneaux", "Windler", "Issac", "27/02/2021"));
    }
}
