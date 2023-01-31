package kemalkeskin.productDemo.business.abstracts;

import java.util.List;

import kemalkeskin.productDemo.business.requests.product.CreateProductRequest;
import kemalkeskin.productDemo.business.requests.product.ProductUpdateRequest;
import kemalkeskin.productDemo.business.responses.product.ProductListResponse;
import kemalkeskin.productDemo.business.responses.product.ProductResponse;
import kemalkeskin.productDemo.entities.Dto.ProductWithCategoryDto;

public interface ProductService {

	List<ProductListResponse>getAll();
																// pageable bi bak
	List<ProductListResponse>getAll(int pageNo, int pageSize);  // pageno: kaçınıcı sayfa oldugunu belırtır.
											//pagesize :bir sayfada kaç data-veri oldugunu,gösterilmek istenen mıktarı bize gösterir.
	
	// listeyı ıstedğim sarta göre sırala
	List<ProductListResponse>getAllSorted();
	
	
	//sort bi bak spring domain 
	List<ProductListResponse>getAllSortedPrice();
	
	
	ProductResponse getById(int id);
	ProductResponse add(CreateProductRequest createProductRequest);
	ProductResponse update(ProductUpdateRequest productUpdateRequest ,int id);
	void delete(int id);
	
	ProductResponse getByProductName(String productName);
	
	ProductResponse getByProductNameOrCategory_categoryId(String productName,int categoryId);
	
	ProductResponse getByProductNameAndCategory_categoryId(String productName,int categoryId);

	List<ProductListResponse> getByProductNameStartsWith(String productName);
	
	List<ProductListResponse> getByProductNameContains(String productName);
	
	List<ProductListResponse> getByCategory_categoryIdIn(List<Integer>categoies);
	
	List<ProductWithCategoryDto>getProductWithCategoryDetails();
}
