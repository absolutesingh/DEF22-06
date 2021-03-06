package arrays;
//https://leetcode.com/problems/set-matrix-zeroes/
class Solution2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;//rows
        int n = matrix[0].length;//cols
        boolean rows[] = new boolean[m];
        boolean cols[] = new boolean[n];
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    rows[i] = true; //make ith row zero in the end
                    cols[j] = true; //make jth col zero in the end
                }
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((rows[i] == true) || cols[j] == true)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}