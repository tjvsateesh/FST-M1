package activities;

public class Activity8 {

	public static void main(String[] args) {
		
		try {
            exceptionTest("Will print to console");
            exceptionTest(null);
        } catch(CustomException ce) {
            System.out.println("Exception handled: " + ce.getMessage());
        }
		
	}
	
	public static void exceptionTest(String value) throws CustomException {
		
		if(value == null)
            throw new CustomException("String value is null");
        else
            System.out.println(value);
		
	}

}
