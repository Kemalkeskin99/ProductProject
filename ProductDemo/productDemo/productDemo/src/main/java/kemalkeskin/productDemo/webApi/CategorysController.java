package kemalkeskin.productDemo.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kemalkeskin.productDemo.business.abstracts.CategoryService;
import kemalkeskin.productDemo.business.requests.category.CategoryUpdateRequest;
import kemalkeskin.productDemo.business.requests.category.CreateCategoryRequest;
import kemalkeskin.productDemo.business.responses.category.CategoryListResponse;
import kemalkeskin.productDemo.business.responses.category.CategoryResponse;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/categoies")
@AllArgsConstructor
@CrossOrigin
public class CategorysController {

	private CategoryService categoryService;
	
	@GetMapping
	public List<CategoryListResponse>getAll(){
		return categoryService.getAll();
	}
	
	@GetMapping("/{id}")
	public CategoryResponse getById(@PathVariable int id){
		return categoryService.getById(id);
	}
	
	@PostMapping
	public CategoryResponse add(@RequestBody CreateCategoryRequest createCategoryRequest) {
		return categoryService.add(createCategoryRequest);
	}
	
	@PutMapping
	public CategoryResponse update(@RequestBody CategoryUpdateRequest categoryUpdateRequest, @RequestParam int id) {
		return categoryService.update(categoryUpdateRequest, id);
	}
	
	@DeleteMapping
	public void delete( int id) {
		this.categoryService.delete(id);
	}
	
}
