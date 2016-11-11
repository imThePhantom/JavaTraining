/**
 * 
 */
package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Phan Toan
 *
 */
public class HorseRacing {
	static final int FREQUENCY = 200;
	static final int DISTANCE = 3000;
	static final int MAX_STEP_DIS = 500;
	static final CyclicBarrier BARRIER = new CyclicBarrier(11);
	static int Winner;
	static boolean RACE_OVER = false;

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		int step = 0;
		String time = "0s000";
		Horse[] match = new Horse[10];

		for (int i = 0; i < 10; i++) {
			match[i] = new Horse(i);
			match[i].setDaemon(true);
		}

		System.out.println("Time:  \t\t1\t2\t3\t4\t5\t6\t7\t8\t9\t10");
		System.out.printf(time + "\t:\t");
		for (Horse horse : match) {
			System.out.printf(horse.remainDistance + "\t");
			horse.start();
		}
		System.out.print("meters\n");
		BARRIER.await();

		do {
			step++;
			time = (step) * FREQUENCY / 1000 + "s" + (step) * FREQUENCY % 1000
					+ ((step) * FREQUENCY % 1000 == 0 ? "00" : "");
			System.out.printf(time + " \t:\t");
			for (Horse horse : match) {
				System.out.print(horse.remainDistance + "\t");
			}
			System.out.print("meters\n");
			Thread.sleep(FREQUENCY);
		} while (!RACE_OVER);

		System.out.println("Winner is player " + (Winner+1) + " after " + time);
	}
}
