package hh.sof3as.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class BookController {
	@RequestMapping("/index")
	public String indexMessage() {
		return "index";
	}
}