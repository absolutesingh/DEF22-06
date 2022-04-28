package bitwise;
//https://practice.geeksforgeeks.org/problems/set-kth-bit3724/1/
public class SetKthBit{
    static int setKthBit(int N,int K){
        return ((1<<K)|N);
    }
}
