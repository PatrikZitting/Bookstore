package hh.sof3as.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.sof3as.Bookstore.domain.Category;
import hh.sof3as.Bookstore.domain.CategoryRepository;


@Controller

public class CategoryController {
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value="/categorylist")
	public String categoryList(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}
	
	@RequestMapping(value = "/addcategory")
    public String addCategory(Model model){
    	model.addAttribute("category", new Category());
        return "addCategory";
    }
	
	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
    public String saveCategory(Category category){
        crepository.save(category);
        return "redirect:categorylist";
    }
}