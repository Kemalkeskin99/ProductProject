package kemalkeskin.productDemo.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kemalkeskin.productDemo.business.abstracts.CategoryService;
import kemalkeskin.productDemo.business.requests.category.CategoryUpdateRequest;
import kemalkeskin.productDemo.business.requests.category.CreateCategoryRequest;
import kemalkeskin.productDemo.business.responses.category.CategoryListResponse;
import kemalkeskin.productDemo.business.responses.category.CategoryResponse;
import kemalkeskin.productDemo.dataAccess.abstracts.CategoryRepository;
import kemalkeskin.productDemo.entities.concretes.Category;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService{

	private CategoryRepository categoryRepository;
	
	@Override
	public List<CategoryListResponse> getAll() {
		
		return categoryRepository.findAll().stream().map(this::categoryListResponse).collect(Collectors.toList());
	}

	@Override
	public CategoryResponse getById(int id) {
		Optional<Category>categories=categoryRepository.findById(id);
		if(categories.isPresent()) {
			
			return categoryResponse(categories.get());
		}
		return null;
		
		
	}
	@Override
	public CategoryResponse add(CreateCategoryRequest createCategoryRequest) {
		
		Category category=new Category();
		category.setCategoryName(createCategoryRequest.getCategoryName());
		return this.categoryResponse( categoryRepository.save(category));
		
	}

	@Override
	public CategoryResponse update(CategoryUpdateRequest categoryUpdateRequest,int id) {
		Optional<Category>categoryUpdate=categoryRepository.findById(id);
		if(categoryUpdate.isPresent()) {
		Category category=categoryUpdate.get();
		category.setCategoryName(categoryUpdateRequest.getCategoryName());
		return categoryResponse(this.categoryRepository.save(category));	
		}
		return null;
	}

	@Override
	public void delete(int id) {
		Optional<Category> categories=categoryRepository.findById(id);
		if(categories.isPresent()) {
			this.categoryRepository.deleteById(id);
		}
		return;
		
	}
	
	public Category giveMeId(int id) {
		
		return categoryRepository.findById(id).orElse(null);
	}

	public CategoryListResponse categoryListResponse(Category category) {
		CategoryListResponse listResponses=new CategoryListResponse();
		listResponses.setCategoryId(category.getCategoryId());
		listResponses.setCategoryName(category.getCategoryName());
		return listResponses;
	}
	
	public CategoryResponse categoryResponse(Category category) {
		CategoryResponse toCategoryResponse=new CategoryResponse();
		toCategoryResponse.setCategoryId(category.getCategoryId());
		toCategoryResponse.setCategoryName(category.getCategoryName());
		return toCategoryResponse;
	}
}
