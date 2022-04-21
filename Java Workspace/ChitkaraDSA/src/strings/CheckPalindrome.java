package strings;

public class CheckPalindrome {

	static boolean checkPalindrome(String s)
	{
		s = s.toLowerCase();
		int l = 0;
		int r = s.length() - 1;
		while(l<r)
		{
			if(s.charAt(l) != s.charAt(r))
			{
				return false; //Not a palindrome
			}
			l++;
			r--;
		}
		//we reach this point -> loop did not return false -> String is Palindrome
		return true;
	}
	
	public static void main(String[] args) {
		String s = "ARORA";
		String s2 = "HELLO";
		String s3 = "Malayalam";
		System.out.println(checkPalindrome(s));
		System.out.println(checkPalindrome(s2));
		System.out.println(checkPalindrome(s3));
	}

}
