package kgw.reservation.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kgw.reservation.domain.Category;
import kgw.reservation.dto.ResponseCode;
import kgw.reservation.service.CategoryService;

@Controller
@RequestMapping("/admin/categorys")
public class CategoryController {
	private static final String DIRNAME ="/admin/categorys";
	CategoryService categoryService;
	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	@GetMapping
	public String index(Model model) {
		getIndexInfo(model);
		
		return DIRNAME+"/index";
	}
	@PostMapping
	public String create(@Valid @ModelAttribute Category category, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			getIndexInfo(model);
			model.addAttribute("error","빈 값은 넣을수 없습니다.");
			return DIRNAME+"/index";
		}
		
		categoryService.create(category);
		return "redirect:"+DIRNAME;
	}
	@PutMapping("/{id}")
	@ResponseBody
	public ResponseCode update(@PathVariable String id, @Valid @RequestBody Category category) {
		category.setId(Long.parseLong(id));
		return categoryService.update(category) ? new ResponseCode(1) : new ResponseCode(0);
	}
	@DeleteMapping("/{id}")
	@ResponseBody
	public ResponseCode delete(@PathVariable String id) {
		return categoryService.delete(Long.parseLong(id)) ? new ResponseCode(1) : new ResponseCode(0);
	}
	
	private void getIndexInfo(Model model) {
		model.addAttribute("list", categoryService.find());
		model.addAttribute("url", DIRNAME);
	}
}
