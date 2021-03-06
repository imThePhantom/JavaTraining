package demo;
/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public class LabelBreakDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Break with no label:\n");
		breakWithNoLabel();

		System.out.println("\n\nBreak with label:\n");
		breakWithLabel();
		
		System.out.println("\n\nContinue with label:\n");
		continueWithLabel();
	}

	public static void breakWithNoLabel() {
		for (int i = 0; i < 10; i++) {
			System.out.print("i:" + i + " ");
			for (int j = 0; j < 10; j++) {
				System.out.print(j + " ");
				if (i == (9 - j) && i < j) {
					break;
				}
				if (i > (9 - j) && i == j) {
					break;
				}
			}
			System.out.print("\n");
		}
	}

	public static void breakWithLabel() {
		int i = 0;
		label: while (i < 5) {
			System.out.print("i:" + i + " ");
			int j = 0;
			while (j < 5) {
				if ((i > 0) && (i == j)) {
					break label;
				}
				System.out.print(j + " ");
				j++;
			}
			i++;
			System.out.print("\n");
		}
	}

	public static void continueWithLabel() {
		String searchMe = "substring in head of string";
		String substring = "string";
		boolean foundIt = false;

		int max = searchMe.length() - substring.length();

		test:
		for (int i = 0; i <= max; i++) {
			int n = substring.length();
			int j = i;
			int k = 0;
			while (n-- != 0) {
				System.out.print(searchMe.charAt(j));
				if (searchMe.charAt(j++) != substring.charAt(k++)) {
					System.out.println("\n" + j + ": " + searchMe.charAt(j-1));
					continue test;
				}
			}
			foundIt = true;
			break test;
		}
		System.out.println(foundIt ? "\nFound it" : "\nDidn't find it");
	}
}
