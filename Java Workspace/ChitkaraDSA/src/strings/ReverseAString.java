package strings;

public class ReverseAString {

	public static void main(String[] args) {
		String s = "Hello";
		
//		Approach - 1
		String res = "";
		for(int i=s.length()-1;i>=0;i--)
		{
			res = res + s.charAt(i); //Creating objects again and again
		}
//		T.C. -> O(n)
		System.out.println("Reveresed String using Approach 1 is: " + res);
		
//		Approach - 2
		char arr[] = new char[s.length()];
		
		for(int i=s.length()-1;i>=0;i--)
		{
			arr[s.length()- 1 - i] = s.charAt(i);
		}
		//the arr contains the characters in reverse order
		String res2 = new String(arr);
//		T.C. -> O(n)
//		S.C. -> O(n)
		System.out.println("Reveresed String using Approach 2 is: " + res2);
		
//		Approach - 3
		char charArr[] = s.toCharArray();
		int l = 0;
		int r = s.length() - 1;
		while(l<r)
		{
			char temp = charArr[l];
			charArr[l] = charArr[r];
			charArr[r] = temp;
			l++;
			r--;
		}
//		charArray has reversed elements now
		String res3 = new String(arr);
//		T.C. -> O(n)
//		S.C. -> O(n)
		System.out.println("Reveresed String using Approach 3 is: " + res3);
	}

}
