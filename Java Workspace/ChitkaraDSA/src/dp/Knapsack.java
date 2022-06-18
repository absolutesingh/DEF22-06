package dp;

//https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1/
public class Knapsack {

	static int knapsack(int W, int wt[], int val[], int n) {
		if (W == 0 || n == 0)
			return 0;

		if (wt[n - 1] > W) // can't pick - item is heavier than knapsack capacity
		{
			return knapsack(W, wt, val, n - 1);
		}

		// Two Options
		int pick = val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1);
		int dontPick = knapsack(W, wt, val, n - 1);

		return Math.max(pick, dontPick);
	}

	static int knapsackM(int W, int wt[], int val[], int n, int dp[][]) {
		if (W == 0 || n == 0)
			return 0;

		if (dp[W][n] != 0)
			return dp[W][n];

		if (wt[n - 1] > W) // can't pick - item is heavier than knapsack capacity
		{
			return knapsack(W, wt, val, n - 1);
		}

		// Two Options
		int pick = val[n - 1] + knapsack(W - wt[n - 1], wt, val, n - 1);
		int dontPick = knapsack(W, wt, val, n - 1);

		dp[W][n] = Math.max(pick, dontPick);
		return dp[W][n];
	}

	static int knapsackT(int W, int wt[], int val[], int n) {
		if (W == 0 || n == 0)
			return 0;

		int dp[][] = new int[W + 1][n + 1];

		for (int i = 0; i < W + 1; i++) // i denotes capacity of knapsack
		{
			for (int j = 0; j < n + 1; j++) // j denotes number of items
			{
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (wt[j - 1] > i) {
					dp[i][j] = dp[i][j - 1];
				} else {
					dp[i][j] = Math.max(val[j - 1] + dp[i - wt[j - 1]][j - 1], dp[i][j - 1]);
				}
			}
		}

		return dp[W][n];
	}

	public static void main(String[] args) {
		int W = 50;
		int n = 4;
		int val[] = { 120, 60, 100, 200 };
		int wt[] = { 30, 20, 10, 60 };
		System.out.println(knapsack(W, wt, val, n));

		int dp[][] = new int[W + 1][n + 1];
		System.out.println(knapsackM(W, wt, val, n, dp));

		System.out.println(knapsackT(W, wt, val, n));
	}

}
