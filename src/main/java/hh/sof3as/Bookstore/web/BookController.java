package hh.sof3as.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hh.sof3as.Bookstore.domain.Book;
import hh.sof3as.Bookstore.domain.BookRepository;
import hh.sof3as.Bookstore.domain.CategoryRepository;


@Controller

public class BookController {
	@RequestMapping("/index")
	public String indexMessage() {
		return "index";
	}
	
	@Autowired
	private BookRepository brepository;
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/booklist")
	public String bookList(Model model) {
		model.addAttribute("books", brepository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	brepository.deleteById(bookId);
        return "redirect:../booklist";
    }
	
	@RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addBook";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book){
        brepository.save(book);
        return "redirect:booklist";
    }
	
	@RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
    model.addAttribute("book", brepository.findById(bookId));
    return "editBook";
    }
}