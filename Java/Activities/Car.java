package activities;

public class Car {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	public Car() {
		this.tyres = 4;
		this.doors = 4;
	}
	
	public void displayCharacteristics() {
		System.out.println("Color of the car is: " + color);
		System.out.println("This car comes with " + transmission + " Transmission");
		System.out.println("Manufacture year: " + make);
		System.out.println("Number of Tyres: " + tyres);
		System.out.println("Number of Doors: " + doors);
	}
	
	public void accelarate() {
		System.out.println("Car is moving forward.");
	}
	
	public void brake() {
		System.out.println("Car has stopped.");
	}
}
