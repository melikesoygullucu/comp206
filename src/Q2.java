 public class Q2 {

	public static void fermatsTheorem(int p, int k) {
		if (p == 1) { // O(1) it just comparing once
			System.out.println(p + " is not a prime number."); // O(1)
		}
		for (int i = 0; i < k; i++) { // O(n) because for loops returns k times
			double result = (Math.pow(k, p) - k) % p;  // O(1) it just assigns
			if (result == 0) { // O(1)
				System.out.println(p + " is a prime number.");// O(1)
				break;
			}
			System.out.println(p + " is not a prime number. ");// O(1)
			break;
		}
	}

	public static void main(String[] args) {
		int p = 53; // O(1)
		int k = 2;  // O(1)
		fermatsTheorem(p, k);
	}
}
//overall, O(1) + O(n) = O(n) time complexity.