/**
 * 
 */
package collection;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author Phan Toan
 *
 */
public class WordCounter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> wordCounter = new TreeMap<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input a string:");
		String tmp = sc.nextLine();
		String[] word = tmp.toLowerCase().replaceAll("[.\",'()]", "").split(" ");
		
		for (String key : word) {
			if (wordCounter.get(key) == null) {
				wordCounter.put(key, 1);
				continue;
			}
			int wordNo = wordCounter.get(key) + 1;
			wordCounter.put(key, wordNo);
		}
		
		for (String result : wordCounter.keySet()) {
			System.out.println(result + " : " + wordCounter.get(result));
		}
		sc.close();
	}
}
