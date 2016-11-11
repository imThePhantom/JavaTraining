package demo;
/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public class LoopSelectionDemo {

	/**
	 * Demo loop - selection
	 */
	public static void main(String[] args) {
		
		String input = "aaaabcadefg";
		String output = "";
		
		input = input + " ";
		for (int i = 1; i < input.length(); i++) {
			if ((input.charAt(i) != input.charAt(i-1))) {
				output = output + input.charAt(i-1);
			} else if (output.length() > 0) {
				output = output + input.charAt(i-1);
				break;
			}

		}
		
		System.out.println("Input: " + input);
		System.out.println("Output: " + output);

	}
	
	

}
