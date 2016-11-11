package demo;
/**
 * 
 */

/**
 * @author Phan Toan
 *
 */
public class OperatorsDemo {

	/**
	 * Demo operators
	 */
	public static void main(String[] args) {
		int num1 = 37;
		int num2 = -9;
		int num3 = 12;
		int num4 = 6;
		boolean b = true;
		System.out.printf("a:%d a++:%d a:%d\n", num1, num1++, num1);
		
		System.out.printf("num2:%d --num2:%d num2:%d\n", num2, --num2, num2);
		System.out.printf("num2:%d -num2:%d num2:%d\n", num2, -num2, num2);
		System.out.printf("num2:%d ~num2:%d num2:%d\n", num2, ~num2, num2);
		
		System.out.printf("num2:%d num2<<1:%d num2:%d\n", num2, num2<<1, num2);
		System.out.printf("num2:%d num2>>=:%d num2:%d\n", num2, num2>>=2, num2);
		System.out.printf("num2:%d num2>>>1:%d num2:%d\n", num2, num2>>>1, num2);
		
		System.out.printf("b:%b !b:%b b:%b\n", b, !b, b);
		
		System.out.printf("num3:%d num3&num4:%d num4:%d\n", num3, num3&num4, num4);
		System.out.printf("num3:%d num3^num4:%d num4:%d\n", num3, num3^num4, num4);
		System.out.printf("num3:%d num3|num4:%d num4:%d\n", num3, num3|num4, num4);
		
		System.out.printf("num3:%d num4:%d num3+=num4:%d num3:%d\n", num3, num4, num3+=num4, num3);
		
		System.out.printf("num3:%d [num3 > 10 ? num2 : num4]:%d\n", num3, num3 > 10 ? num2 : num4 );
	}

}
