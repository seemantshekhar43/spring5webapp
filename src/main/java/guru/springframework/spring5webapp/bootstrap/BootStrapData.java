package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher bloomsbury = new Publisher("Bloomsbury", "New Road", "New Delhi", "New Delhi", "110001");
        Publisher rupa = new Publisher("Rupa", "New Road", "New Delhi", "New Delhi", "110001");
        publisherRepository.save(bloomsbury);
        publisherRepository.save(rupa);

        Author dan = new Author("Dan", "Brown");
        Book daCode = new Book("The da vince code", "qwerty123");
        dan.getBooks().add(daCode);
        daCode.getAuthors().add(dan);
        daCode.setPublisher(bloomsbury);
        bloomsbury.getBooks().add(daCode);
        authorRepository.save(dan);
        bookRepository.save(daCode);


        Author ashwin = new Author("Ashwin", "Sanghi");
        Book rLine = new Book("The rosabel line", "abcde1");
        ashwin.getBooks().add(rLine);
        rLine.getAuthors().add(ashwin);
        rLine.setPublisher(rupa);
        rupa.getBooks().add(rLine);
        authorRepository.save(ashwin);
        bookRepository.save(rLine);

        System.out.println("Started in Bootstrap");
        System.out.println("No. of books: " + bookRepository.count());

    }
}
