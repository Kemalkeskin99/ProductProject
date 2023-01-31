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

import kemalkeskin.productDemo.business.abstracts.ProductService;
import kemalkeskin.productDemo.business.requests.product.CreateProductRequest;
import kemalkeskin.productDemo.business.requests.product.ProductUpdateRequest;
import kemalkeskin.productDemo.business.responses.product.ProductListResponse;
import kemalkeskin.productDemo.business.responses.product.ProductResponse;
import kemalkeskin.productDemo.entities.Dto.ProductWithCategoryDto;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@CrossOrigin

public class ProductsController {

	private ProductService productService;
	
	@GetMapping("/getall")
	public List<ProductListResponse>getAll(){
		return productService.getAll();
	}
	
	@GetMapping("/{id}")
	public ProductResponse getById (@PathVariable int id){
		return this.productService.getById(id);
	}
	
	@PostMapping
	public ProductResponse add(@RequestBody CreateProductRequest createProductRequest) {
		return this.productService.add(createProductRequest);
	}

	@DeleteMapping
	public void delete(int id) {
		this.productService.delete(id);
	}
	
	@PutMapping
	public ProductResponse update(@RequestBody ProductUpdateRequest productUpdateRequest ,@RequestParam int id) {
		return this.productService.update(productUpdateRequest, id);
	}

	@GetMapping("getbyproductname")
	public ProductResponse getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}
	
	@GetMapping("getbyproductnameorcategory")
	public ProductResponse getByProductNameOrCategory_categoryId(@RequestParam String productName, @RequestParam int categoryId) {
		return this.productService.getByProductNameOrCategory_categoryId(productName, categoryId);
	}
	
	@GetMapping("getbyproductnameandcategory")
	public ProductResponse getByProductNameAndCategory_categoryId(@RequestParam String productName, @RequestParam int categoryId) {
		return this.productService.getByProductNameAndCategory_categoryId(productName, categoryId);
	}
	
	@GetMapping("getbyproductnamestartswith")
	public  List<ProductListResponse> getByProductNameStartsWith(@RequestParam String productName) {
		return this.productService.getByProductNameStartsWith(productName);
	}
	
	@GetMapping("getbyproductnamecontains")
	public List<ProductListResponse> getByProductNameContains(@RequestParam String productName){
		return this.productService.getByProductNameContains(productName);
	}
	
	@GetMapping("getbycategoryıdın")
	public List<ProductListResponse> getByCategory_categoryIdIn(@RequestParam List<Integer> categoies) {
		return this.productService.getByCategory_categoryIdIn(categoies);
	}
	
	@GetMapping("getAllByPage")
	public List<ProductListResponse> getAll(int pageNo, int pageSize){
		return this.productService.getAll(pageNo, pageSize);
	}
	
	@GetMapping("getAllByAsc")
	public List<ProductListResponse> getAllSorted(){
		return this.productService.getAllSorted();
	}
	
	@GetMapping("getAllByAscPrice")
	public List<ProductListResponse> getAllSortedPrice(){
		return this.productService.getAllSortedPrice();
	}
	@GetMapping("getproductwithcategorydetails")
	public List<ProductWithCategoryDto>getProductWithCategoryDetails(){
	return this.productService.getProductWithCategoryDetails();
	}
	
	}
