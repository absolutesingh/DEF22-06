package bitwise;
//https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1/
public class CheckBit
{
    
    // Function to check if Kth bit is set or not.
    static boolean checkKthBit(int n, int k)
    {
        if((((1<<k)&n))==0) return false;
        
        return true;
    }
    
    // Function to check if Kth bit is set or not.
    static boolean checkKthBitChangingNumber(int n, int k)
    {
        if(((n>>k) & 1) == 1) return true;
        return false;
    }
    
}
