package kemalkeskin.productDemo.core.utilities.ProductResponse;

import kemalkeskin.productDemo.business.responses.product.ProductListResponse;
import kemalkeskin.productDemo.business.responses.product.ProductResponse;
import kemalkeskin.productDemo.entities.concretes.Product;

public class ProductModel {
	public static ProductListResponse productListResponse(Product product) {
		ProductListResponse listResponse=new ProductListResponse();
		listResponse.setProductId(product.getProductId());
		listResponse.setCategoryId(product.getCategory().getCategoryId());
		listResponse.setProductName(product.getProductName());
		listResponse.setUnitPrice(product.getUnitPrice());
		listResponse.setStocksAmount(product.getStocksAmount());
		return listResponse;
	}
	
	public static ProductResponse productResponse(Product product) {
		ProductResponse productResponses=new ProductResponse();
		productResponses.setProductId(product.getProductId());
		productResponses.setCategoryId(product.getCategory().getCategoryId());
		productResponses.setProductName(product.getProductName());
		productResponses.setUnitPrice(product.getUnitPrice());
		productResponses.setStocksAmount(product.getStocksAmount());
		return productResponses;
	}
}
