package kemalkeskin.productDemo.business.requests.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	
	private int categoryId;
	private String productName;
	private double unitPrice;
	private int stocksAmount;
//	private String loadingDate;

	
}
