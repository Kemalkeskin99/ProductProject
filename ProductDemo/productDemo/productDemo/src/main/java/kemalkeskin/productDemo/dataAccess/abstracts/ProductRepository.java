package kemalkeskin.productDemo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kemalkeskin.productDemo.entities.Dto.ProductWithCategoryDto;
import kemalkeskin.productDemo.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	Product getByProductName(String productName);
	
	Product getByProductNameOrCategory_categoryId(String productName,int categoryId);
	
	Product getByProductNameAndCategory_categoryId(String productName,int categoryId);
	
	List<Product> getByProductNameStartsWith(String productName);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByCategory_categoryIdIn(List<Integer>categoies);
	
	
	@Query("select new kemalkeskin.productDemo.entities.Dto.ProductWithCategoryDto(p.productId,p.productName,c.categoryName) from Category c Inner Join c.products p ")
	List<ProductWithCategoryDto>getProductWithCategoryDetails();
	
	// c.products =products yazmamızın nedeni  category classında ilişkide kullandıgımız isim.
// category ilk yazmamızın nedenı category base  sayfam yani ilişkide catgeory one product many oldugu için product 2 sıraya yazdık 
	
	// sql kdou
	// select p.productId,p.productName,c.categoryName from Category c inner join Product P on c.categoryId=p.categoryId
}