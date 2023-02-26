package hh.sof3as.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import hh.sof3as.Bookstore.domain.Book;
import hh.sof3as.Bookstore.domain.BookRepository;
import hh.sof3as.Bookstore.domain.Category;
import hh.sof3as.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book b1 = new Book("Itselleni", "Marcus Aurelius", 2022, 12345, 24.90);
			Book b2 = new Book("Harry Potter ja viisasten kivi", "J.K Rowling", 1997, 54321, 15.90);
			
			repository.save(b1);
			repository.save(b2);
		};
	}
	
	@Bean
	public CommandLineRunner demo2(CategoryRepository repository) {
		return (args) -> {
			Category c1 = new Category("Philosophy");
			Category c2 = new Category("Fiction");
			
			repository.save(c1);
			repository.save(c2);
		};
	}

}
