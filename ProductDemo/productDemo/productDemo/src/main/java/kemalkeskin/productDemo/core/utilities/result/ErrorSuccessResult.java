package kemalkeskin.productDemo.core.utilities.result;

public class ErrorSuccessResult extends Result {

	public ErrorSuccessResult() {
		super(false);
		
	}
	public ErrorSuccessResult(String message) {
		super(false, message);
		
	}
}
