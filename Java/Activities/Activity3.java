package activities;

public class Activity3 { 
	
	public static void main(String[] args) {
		double seconds = 10_00_00_00_00;
		
		double earthSeconds = 31557600;
		double jupiterSeconds = 11.862615;
		double marsSeconds = 1.8808158;
		double mercurySeconds = 0.2408467;
		double neptuneSeconds = 164.79132;
		double saturnSeconds = 29.447498;
		double uranusSeconds = 84.016846;
		double venusSeconds = 0.61519726;
		
		System.out.println("Age on Earth is: "+ seconds/earthSeconds);
		System.out.println("Age on Jupiter is: "+ (seconds/earthSeconds)/jupiterSeconds);
		System.out.println("Age on Mars is: "+ (seconds/earthSeconds)/marsSeconds);
		System.out.println("Age on Mercury is: "+ (seconds/earthSeconds)/mercurySeconds);
		System.out.println("Age on Neptune is: "+ (seconds/earthSeconds)/neptuneSeconds);
		System.out.println("Age on Saturn is: "+ (seconds/earthSeconds)/saturnSeconds);
		System.out.println("Age on Uranus is: "+ (seconds/earthSeconds)/uranusSeconds);
		System.out.println("Age on Venus is: "+ (seconds/earthSeconds)/venusSeconds);
		
	}

}
