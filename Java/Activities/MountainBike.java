package activities;

public class MountainBike extends Bicycle {
	
	int seatHeight;

	public MountainBike(int gears, int currentSpeed, int heightOfSeat) {
		super(gears, currentSpeed);
		seatHeight = heightOfSeat;
	}
	
	public void setHeight(int newValue) {
	    seatHeight = newValue;
	}
	
	@Override
	public String bicycleDesc() {
		return (super.bicycleDesc()+ "\nSeat height is " + seatHeight);
	}
}
