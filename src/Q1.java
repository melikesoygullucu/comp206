import java.util.Scanner;

public class Q1 {
	public static void hexToDecimal(int x) {
		String str = "";      // O(1)
		char hex[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };     // O(1)
		while (x > 0) {     // O(log n) becuase in each iteration, number is divided by 16 
			int remainder = x % 16;    // O(1)
			str = hex[remainder] + str;  // O(1)
			x /= 16;   // O(1)
		}
		System.out.println("Hexadecimal number: " + str);  // O(1)
	}
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);     // O(1)
		System.out.print("Enter a decimal number : ");    // O(1)
	    int x = scan.nextInt();     // O(1)
	    hexToDecimal(x);     // O(1)
	} 
}
// overall, O(1) + O(log n) = O(log n) time complexity.