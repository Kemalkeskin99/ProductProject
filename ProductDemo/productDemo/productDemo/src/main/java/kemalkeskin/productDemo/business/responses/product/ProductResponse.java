package kemalkeskin.productDemo.business.responses.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	private int productId;
	private int categoryId;
	private String productName;
	private double unitPrice;
	private int stocksAmount;
}
