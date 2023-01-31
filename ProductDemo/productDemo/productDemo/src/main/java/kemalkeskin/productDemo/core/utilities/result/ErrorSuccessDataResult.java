package kemalkeskin.productDemo.core.utilities.result;

public class ErrorSuccessDataResult<T> extends DataResult<T> {

	public ErrorSuccessDataResult(T data) {
		super(data, false);
		
	}
	
	public ErrorSuccessDataResult(T data,String message) {
		super(data, false,message);
		
	}

	public ErrorSuccessDataResult() {
		super(null, false);
		
	}
	public ErrorSuccessDataResult(String message) {
		super(null, false,message);
		
	}
}
