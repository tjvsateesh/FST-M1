package activities;

public class Activity7 {

	public static void main(String[] args) {

		MountainBike mbike = new MountainBike(7, 8, 25);
		System.out.println(mbike.bicycleDesc());
		mbike.speedUp(20);
		mbike.applyBrake(5);

	}

}
