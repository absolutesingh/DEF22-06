package strings;
//https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1
class Solution2 {
    
    static boolean compare(int arr1[], int arr2[]) //compare if two arrays are equal
    {
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]!=arr2[i])
            {
                return false;
            }
        }
        return true;
    }

    int search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        
        int count = 0;
        
        int freqArrPat[] = new int[256];
        int freqArrWin[] = new int[256];
        
        for(int i=0;i<m;i++)
        {
            freqArrPat[pat.charAt(i)]++; //ASCII values picked
            freqArrWin[txt.charAt(i)]++;
        }
        
        //Freq Arrays created for pattern and first window
        
        for(int i=m;i<n;i++)
        {
            if(compare(freqArrPat, freqArrWin))
            {
                count++;
            }
            
            //Sliding the window
            freqArrWin[txt.charAt(i)]++;
            freqArrWin[txt.charAt(i-m)]--;
            
        }
        
        //comparing explicitly for the last window
        if(compare(freqArrPat, freqArrWin)) 
        {
            count++;
        }
        
        return count;
    }
}