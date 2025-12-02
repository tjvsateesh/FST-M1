package activities;

public class Activity1 {
	
	public static void main(String[] args) {
		
		Car car = new Car();
		car.make = 2025;
		car.transmission = "Automatic";
		car.color = "Black";
		
		car.displayCharacteristics();
		car.accelarate();
		car.brake();
		
	}

}
