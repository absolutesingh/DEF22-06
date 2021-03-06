package arrays;
//https://leetcode.com/problems/set-matrix-zeroes/
class Solution3 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;//rows
        int n = matrix[0].length;//cols
        boolean makeFirstColZero = false;
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j] == 0)
                {
                    if(j==0) //make first col zero
                    {
                        makeFirstColZero = true;
                        // matrix[i][0] = 0; //No need of this
                    }
                    else{
                        matrix[i][0] = 0; //using first col of matrix itself
                        matrix[0][j] = 0; //using first row of matrix itself
                    }
                }
            }
        }
        
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if((matrix[i][0] == 0) || matrix[0][j] == 0)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0) //make first row zero
        {
            for(int i=0;i<n;i++)
            {
                matrix[0][i] = 0;
            }
        }
        
        if(makeFirstColZero) //[makeFirstColZero == true]
        {
            for(int i=0;i<m;i++)
            {
                matrix[i][0] = 0;
            }
        }
        
    }
}