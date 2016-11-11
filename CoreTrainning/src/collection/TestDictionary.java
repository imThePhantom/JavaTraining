/**
 * 
 */
package collection;

/**
 * @author Phan Toan
 *
 */
public class TestDictionary {
	
	public static void main(String[] args) {
		int[] k1 = {1, 2, 3};
		int[] k2 = {2, 4, 6};
		String[] value = {"good", "normal", "bad"};
		Dictionary myDict = new Dictionary();
		for (int i = 0; i < 3; i++) {
			myDict.put(k1[i], k2[i], value[i]);
		}
		myDict.put(k1, k2, "good");
		
		System.out.println(myDict.get(k1[0], k2[0]));
		System.out.println(myDict.containKet(k1[1], k2[1]));
		System.out.println(myDict.containKet(k1[1], k2[2]));
	}

}
