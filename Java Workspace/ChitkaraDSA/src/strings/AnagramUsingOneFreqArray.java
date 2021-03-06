package strings;

public class AnagramUsingOneFreqArray {

	static boolean isAnagram(String s1, String s2)
	{
		if(s1.length()!=s2.length()) return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		int freqArr[] = new int[26]; //For Ques with special characters -> 256 size array
		
		for(int i=0;i<s1.length();i++)
		{
			char ch1 = s1.charAt(i);
			int index = ch1 - 'a'; //mapping character to index[with respect to 'a']
			freqArr[index]++; //For String 1
			
			freqArr[s2.charAt(i) - 'a']--; //For String 2
		}
		//frequency arrays have been created
		
		for(int i=0;i<26;i++)
		{
			if(freqArr[i]!=0)
			{
				return false;
			}
		}
		
		//If reached at this point -> Freq Array has everything zero -> Strings are Anagram
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(isAnagram("CAT", "TAC"));
		System.out.println(isAnagram("CAT", "TAG"));
		System.out.println(isAnagram("CAT", "TACC"));
		System.out.println(isAnagram("INTEGRAL", "Triangle"));
	}

}
