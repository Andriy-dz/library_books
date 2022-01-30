package books.controller;

import books.model.Author;
import books.model.Book;
import books.service.AuthorService;
import books.service.BookService;
import java.time.LocalDate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class Injector {
    private final AuthorService authorService;
    private final BookService bookService;

    public Injector(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping
    public String inject() {
        Author rowling = new Author();
        rowling.setPhone("rowling@gmail.com");
        rowling.setEmail("12345678910");
        rowling.setBirthDate(LocalDate.of(1965,7,31));
        rowling.setName("Rowling");
        Author kidruk = new Author();
        kidruk.setPhone("kidruk@gmail.com");
        kidruk.setEmail("12345678910");
        kidruk.setBirthDate(LocalDate.of(1984,4,1));
        kidruk.setName("Kidruk");
        Author kidrud = new Author();
        kidrud.setPhone("kidrud@gmail.com");
        kidrud.setEmail("12345678910");
        kidrud.setBirthDate(LocalDate.of(1984,4,1));
        kidrud.setName("Kidrud");
        authorService.add(rowling);
        authorService.add(kidruk);
        authorService.add(kidrud);

        Book harryPotterTwo = new Book();
        harryPotterTwo.setPublishedAmount(1000);
        harryPotterTwo.setSoldAmount(999);
        harryPotterTwo.setAuthor(rowling);
        harryPotterTwo.setName("Harry Potter and the Chamber of Secrets");
        Book harryPotterThree = new Book();
        harryPotterThree.setPublishedAmount(1000);
        harryPotterThree.setSoldAmount(600);
        harryPotterThree.setAuthor(rowling);
        harryPotterThree.setName("Harry Potter and the Prisoner of Azkaban");
        bookService.add(harryPotterThree);
        bookService.add(harryPotterTwo);

        Book bot = new Book();
        bot.setPublishedAmount(600);
        bot.setSoldAmount(540);
        bot.setAuthor(kidruk);
        bot.setName("Bot. Atacama crisis");
        Book botTwo = new Book();
        botTwo.setPublishedAmount(600);
        botTwo.setSoldAmount(550);
        botTwo.setAuthor(kidruk);
        botTwo.setName("Bot: The Guayaquil paradox");
        bookService.add(bot);
        bookService.add(botTwo);

        Book botCopy = new Book();
        botCopy.setPublishedAmount(600);
        botCopy.setSoldAmount(540);
        botCopy.setAuthor(kidrud);
        botCopy.setName("Copy Bot. Atacama crisis");
        Book botTwoCopy = new Book();
        botTwoCopy.setPublishedAmount(600);
        botTwoCopy.setSoldAmount(550);
        botTwoCopy.setAuthor(kidrud);
        botTwoCopy.setName("Copy Bot: The Guayaquil paradox");

        bookService.add(botCopy);
        bookService.add(botTwoCopy);

        return "Data was create";
    }
}
