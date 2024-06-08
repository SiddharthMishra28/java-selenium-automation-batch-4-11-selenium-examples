package temp;

import org.testng.annotations.Test;

public class CarTrackTest extends Hooks{
	
	@Test
	public void test_car_for_reliability() {
		Track track = new Track(engine);
		track.runInStressTrack();
		track.runInOffroadTrack();
	}
}
