package bitwise;
//https://leetcode.com/problems/counting-bits/
public class CountBits {

	//T.C. -> O(n)
	public int[] countBitsOptimized(int n) {
        int result[] = new int[n+1];
        result[0] = 0;
        for(int i=1;i<n+1;i++)
        {
            
            result[i] = result[i/2] + i%2;
            
            // if(i%2==0)
            // {
            //     result[i] = result[i/2] + 0;
            // }
            // else{
            //     result[i] = result[i/2] + 1;
            // }
        }
        return result;
    }
	
	//T.C. -> O(n*Log(n))
	public int[] countBits(int n) {
		int result[] = new int[n + 1];

		for (int i = 0; i < n + 1; i++) {
			result[i] = countBitsForNumber(i);
		}

		return result;
	}

	static int countBitsForNumber(int n) {
		int count = 0;

		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n = n >> 1;
		}

		return count;
	}

}