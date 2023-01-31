package kemalkeskin.productDemo.business.abstracts;

import java.util.List;

import kemalkeskin.productDemo.business.requests.category.CategoryUpdateRequest;
import kemalkeskin.productDemo.business.requests.category.CreateCategoryRequest;
import kemalkeskin.productDemo.business.responses.category.CategoryListResponse;
import kemalkeskin.productDemo.business.responses.category.CategoryResponse;
import kemalkeskin.productDemo.entities.concretes.Category;

public interface CategoryService {

	List<CategoryListResponse>getAll();
	CategoryResponse getById(int id);
	CategoryResponse add(CreateCategoryRequest createCategoryRequest);
	CategoryResponse update(CategoryUpdateRequest categoryUpdateRequest,int id);
	void delete(int id);
	Category giveMeId(int id);
}
