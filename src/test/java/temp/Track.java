package temp;

public class Track extends CarUtils {
	
	public String stressTest;
	public String offRoadCapabilityTest;
	
	public Track(Engine engine) {
		super(engine);
	}
	
	public void runInStressTrack() {
		System.out.println("Running in stress Track");
	}
	
	public void runInOffroadTrack() {
		System.out.println("Running in offroad Track");
	}
}
