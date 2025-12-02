package activities;

public class Activity5 {
	
	public static void main(String []args) {
		
		String bookTitle = "Harry Potter";
		
		Book book = new MyBook();
		book.setTitle(bookTitle);
		System.out.println("Name of the book is: "+ book.getTitle());
		
	}
	

}
