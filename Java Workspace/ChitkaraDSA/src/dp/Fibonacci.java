package dp;

public class Fibonacci {

	static int fib(int n)// Recursive Approach
	{
		if (n < 2)
			return n;
		return fib(n - 1) + fib(n - 2);
	}

	static int fibM(int n, int storage[])// Memoization
	{
		if (n < 2)
			return n;

		if (storage[n] != 0) // Step 3: Return value from storage if already calculated
		{
			return storage[n];
		}

		storage[n] = fibM(n - 1, storage) + fibM(n - 2, storage); // Step 2: Store the result in array
		return storage[n];
	}

	static int fibT(int n)// Tabulation
	{
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i < n + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		// array filled successfully
		return dp[n];
	}

	public static void main(String[] args) {
		int n = 45;
		long start = System.currentTimeMillis();
		System.out.println(fib(n));
		long end = System.currentTimeMillis();
		System.out.println("Time taken by recursive approach: " + (end - start));

		start = System.currentTimeMillis();
		int storage[] = new int[n + 1]; // Step 1: Create an array to pass
		System.out.println(fibM(n, storage));
		end = System.currentTimeMillis();
		System.out.println("Time taken by Memoized approach: " + (end - start));

		start = System.currentTimeMillis();
		System.out.println(fibT(n));
		end = System.currentTimeMillis();
		System.out.println("Time taken by Tabulation: " + (end - start));
	}

}
