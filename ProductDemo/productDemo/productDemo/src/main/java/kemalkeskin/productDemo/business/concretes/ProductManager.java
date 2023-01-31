package kemalkeskin.productDemo.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kemalkeskin.productDemo.business.abstracts.CategoryService;
import kemalkeskin.productDemo.business.abstracts.ProductService;
import kemalkeskin.productDemo.business.requests.product.CreateProductRequest;
import kemalkeskin.productDemo.business.requests.product.ProductUpdateRequest;
import kemalkeskin.productDemo.business.responses.product.ProductListResponse;
import kemalkeskin.productDemo.business.responses.product.ProductResponse;
import kemalkeskin.productDemo.core.utilities.ProductResponse.ProductModel;
import kemalkeskin.productDemo.dataAccess.abstracts.ProductRepository;
import kemalkeskin.productDemo.entities.Dto.ProductWithCategoryDto;
import kemalkeskin.productDemo.entities.concretes.Category;
import kemalkeskin.productDemo.entities.concretes.Product;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class ProductManager implements ProductService{

	private ProductRepository productRepository;
	private CategoryService categoryService;
	
	@Override
	public List<ProductListResponse> getAll() {
	
	
		return productRepository.findAll().stream().map(ProductModel::productListResponse).collect(Collectors.toList());
	}

	@Override
	public ProductResponse getById(int id) {
	

		Optional<Product>products=productRepository.findById(id);
		if(products.isPresent()) {
			
			 return ProductModel.productResponse(products.get());
		}
		
		return null;
		
	}

	@Override
	public ProductResponse add(CreateProductRequest createProductRequest) {
		Product product= new Product();
		product.setProductName(createProductRequest.getProductName());
		product.setStocksAmount(createProductRequest.getStocksAmount());
		product.setUnitPrice(createProductRequest.getUnitPrice());
		Category category=categoryService.giveMeId(createProductRequest.getCategoryId());
		if(Objects.nonNull(category)) {
			product.setCategory(category);
		}
		
		 return ProductModel.productResponse(productRepository.save(product));
		
		
	}

	@Override
	public ProductResponse update(ProductUpdateRequest productUpdateRequest ,int id) {
		Optional<Product>productUpdate=productRepository.findById(id);
		if(productUpdate.isPresent()) {
			Product product=productUpdate.get();
			product.setProductName(productUpdateRequest.getProductName());
			product.setUnitPrice(productUpdateRequest.getUnitPrice());
			product.setStocksAmount(productUpdateRequest.getStocksAmount());
			Category category=categoryService.giveMeId(productUpdateRequest.getCategoryId());
			if(Objects.nonNull(category)) {
				product.setCategory(category);
			}
			 return ProductModel.productResponse(productRepository.save(product));
			                	
		}
			return null;
	}

	@Override
	public void delete(int id) {
		
		Optional<Product> products=productRepository.findById(id);
		if(products.isPresent()) {
			this.productRepository.deleteById(id);
			
		}
		return;

	}

	@Override
	public ProductResponse getByProductName(String productName) {
		
		return ProductModel.productResponse(this.productRepository.getByProductName(productName));
	}

	@Override
	public ProductResponse getByProductNameOrCategory_categoryId(String productName, int categoryId) {
		
		return ProductModel.productResponse(this.productRepository.getByProductNameOrCategory_categoryId(productName, categoryId));
	}

	@Override
	public ProductResponse getByProductNameAndCategory_categoryId(String productName, int categoryId) {

		return ProductModel.productResponse(this.productRepository.getByProductNameAndCategory_categoryId(productName, categoryId));
	}

	@Override
	public List<ProductListResponse> getByProductNameStartsWith(String productName) {
	
		return productRepository.getByProductNameStartsWith(productName).stream().map(ProductModel::productListResponse).collect(Collectors.toList());
	}

	@Override
	public List<ProductListResponse> getByProductNameContains(String productName) {
		
		return productRepository.getByProductNameContains(productName).stream().map(ProductModel::productListResponse).collect(Collectors.toList());
		
	}

	@Override
	public List<ProductListResponse> getByCategory_categoryIdIn(List<Integer> categoies) {
	
		return productRepository.getByCategory_categoryIdIn(categoies).stream().map(ProductModel::productListResponse).collect(Collectors.toList());
	}

	@Override
	public List<ProductListResponse> getAll(int pageNo, int pageSize) {
			// pageable bi bak
		Pageable pageable= PageRequest.of(pageNo-1, pageSize);
		
		return productRepository.findAll(pageable).getContent().stream().map(ProductModel::productListResponse).collect(Collectors.toList());
		
	}

	@Override
	public List<ProductListResponse> getAllSorted() {
		Sort sort=Sort.by(Sort.Direction.ASC, "productName");
		return productRepository.findAll(sort).stream().map(ProductModel::productListResponse).collect(Collectors.toList());
	}

	@Override
	public List<ProductListResponse> getAllSortedPrice() {
		//sort a bi bak
		
		Sort sort=Sort.by(Sort.Direction.ASC, "unitPrice");
						//by=direction olan
		return productRepository.findAll(sort).stream().map(ProductModel::productListResponse).collect(Collectors.toList());
	}

	@Override
	public List<ProductWithCategoryDto> getProductWithCategoryDetails() {
	
		return this.productRepository.getProductWithCategoryDetails();
	}

	
}
