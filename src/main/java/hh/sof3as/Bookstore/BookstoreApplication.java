	package hh.sof3as.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof3as.Bookstore.domain.Book;
import hh.sof3as.Bookstore.domain.BookRepository;
import hh.sof3as.Bookstore.domain.Category;
import hh.sof3as.Bookstore.domain.CategoryRepository;
import hh.sof3as.Bookstore.domain.User;
import hh.sof3as.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			Category c1 = new Category("Philosophy");
			Category c2 = new Category("Fiction");
			
			crepository.save(c1);
			crepository.save(c2);
			
			Book b1 = new Book("Itselleni", "Marcus Aurelius", 2022, 12345, 24.90, c1);
			Book b2 = new Book("Harry Potter ja viisasten kivi", "J.K Rowling", 1997, 54321, 15.90, c2);
			
			brepository.save(b1);
			brepository.save(b2);
			
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@bookstore.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admin@bookstore.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
		};
	}

}
