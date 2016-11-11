/**
 * 
 */
package thread;

import java.util.Random;

/**
 * @author Phan Toan
 *
 */
public class Horse extends Thread {
	public int remainDistance = HorseRacing.DISTANCE;
	int startNo;

	/**
	 * @param remainDistance
	 * @param totalStep
	 */
	public Horse(int startNo) {
		this.startNo = startNo;
	}

	@Override
	public void run() {
		Random generator = new Random();
		try {
			HorseRacing.BARRIER.await();

			do {
				Thread.sleep(HorseRacing.FREQUENCY);
				int step = generator.nextInt(HorseRacing.MAX_STEP_DIS);
				remainDistance = remainDistance - step;
				if (remainDistance < 0) {
					remainDistance = HorseRacing.DISTANCE;
				}
			} while (remainDistance != 0);
		} catch (Exception e) {
			e.printStackTrace();
		}

		HorseRacing.RACE_OVER = true;
		HorseRacing.Winner = this.startNo;
	}
}
