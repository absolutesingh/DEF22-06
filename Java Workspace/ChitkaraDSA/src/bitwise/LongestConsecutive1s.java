package bitwise;

//https://practice.geeksforgeeks.org/problems/longest-consecutive-1s-1587115620/1/
public class LongestConsecutive1s {
	// A Better Approach
	public static int maxConsecutiveOnes(int N) {

		int count = 0;
		while (N != 0) {
			N = N & (N << 1);
			count++;
		}
		return count;
	}

	/*
	 * Function to calculate the longest consecutive ones N: given input to
	 * calculate the longest consecutive ones
	 */
	public static int maxConsecutiveOnesOld(int N) {
		int maxLen = Integer.MIN_VALUE;
		int count = 0;

		while (N != 0) {
			if ((N & 1) == 1) {
				count++;
				if (maxLen < count) {
					maxLen = count;
				}
			} else {
				count = 0;
			}
			N = N >> 1;
		}

		return maxLen;

	}
}