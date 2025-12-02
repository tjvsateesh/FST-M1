package activities;

public class CustomException extends Exception {
	
	private String message = null;
	
	public CustomException(String exceptionMessage) {
		this.message = exceptionMessage;
	}
	
	@Override
	public String getMessage() {
	    return message;
	}

}
