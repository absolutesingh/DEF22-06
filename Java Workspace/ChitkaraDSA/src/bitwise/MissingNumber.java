package bitwise;
//https://practice.geeksforgeeks.org/problems/missing-number-in-array1416/1/#
class Solution {
    
    int MissingNumber(int array[], int n) {
        int a = 0; //XOR from 1 to n
        for(int i=1;i<=n;i++)
        {
            a = a^i;
        }
        int b = 0; //XOR of array elements
        for(int i=0;i<array.length;i++)
        {
            b = b^array[i];
        }
        
        return a^b;
    }
    
    int MissingNumberUsingArithmetic(int array[], int n) {
        int sum = n*(n+1)/2;
        
        for(int i=0;i<array.length;i++)
        {
            sum = sum - array[i];
        }
        
        //we're left with the missing number
        return sum;
    }
}
