package arrays;
//https://leetcode.com/problems/spiral-matrix/
import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int left = 0; //these are indexes
        int right = matrix[0].length - 1; //these are indexes
        int top = 0; //these are indexes
        int bottom = matrix.length - 1; //these are indexes
        
        while(true) //True because we will tell it to stop
        {
            //Printing top row - from left to right
            for(int i=left;i<=right;i++)
            {
                result.add(matrix[top][i]);
            }
            top++;
            //1st Condition Check
            if(left>right || top>bottom) break;
            
            //Printing right column - from top to bottom
            for(int i=top;i<=bottom;i++)
            {
                result.add(matrix[i][right]);
            }
            right--;
            //2nd Condition Check
            if(left>right || top>bottom) break;
            
            //Printing bottom row - from right to left
            for(int i=right;i>=left;i--)
            {
                result.add(matrix[bottom][i]);
            }
            bottom--;
            //3rd Condition Check
            if(left>right || top>bottom) break;
            
            //Printing left column - from bottom to top
            for(int i=bottom;i>=top;i--)
            {
                result.add(matrix[i][left]);
            }
            left++;
            
            //4th Condition Check
            if(left>right || top>bottom) break;
        }
        
        return result;
    }
}