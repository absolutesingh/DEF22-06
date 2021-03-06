package strings;

import java.util.Scanner;

public class StringStudy {
	static void printAllOccurrences(String s,char c) {
		//We've been said to ignore the case
		s = s.toLowerCase();
		int index = -1;
		while(true)
		{
			index = s.indexOf(c, index + 1);
			if(index == -1)
			{
				System.out.println("Reached End of String");
				break;
			}
			else {
				System.out.println("Character " + c + " found at index: " + index);
			}
			
		}
	}
	public static void main(String[] args) {
		String name = "Chitkara"; //created using string literal -> obj created in String Constant Pool
		String name2 = "Chitkara";
		
		// == operator -> compares references for objects, values for primitive data types
		System.out.println("name and name2 refer to the same object: " + (name == name2));
		
		String name3 = new String("Chitkara"); //created using constructor
		String name4 = new String("Chitkara");
		System.out.println("name3 and name4 refer to the same object: " + (name3 == name4));
		
		System.out.println("name and name4 refer to the same object: " + (name == name4));
		System.out.println("name and name3 refer to the same object: " + (name == name3));
		
//		STRINGS ARE IMMUTABLE
//		Everytime we do an operation on a string, a new string is created
		
//		1. CONCATENATION
		System.out.println("=================================================");
		System.out.println("1. CONCATENATION");
		
		String s1 = "Hello";
		System.out.println("s1: " + s1);
		System.out.println(s1 + " People");
		System.out.println("s1: " + s1);
		
		String s2 = s1.concat(", Good Morning!");
		System.out.println("s2: " + s2);
		System.out.println("s1: " + s1);
		
//		2. CHECK IF STRINGS ARE EQUAL IN VALUE
		System.out.println("=================================================");
		System.out.println("2. CHECK IF STRINGS ARE EQUAL IN VALUE -> EQUALS() FUNCTION");
		
//		s1.equals(s2) -> checks that the two strings have the same data
		System.out.println("name and name2 have the same content: " + name.equals(name2));
		System.out.println("name2 and name3 have the same content: " + name3.equals(name2));
		System.out.println("name3 and name4 have the same content: " + name3.equals(name4));
		System.out.println("name and name3 have the same content: " + name.equals(name3));
		System.out.println("name and name4 have the same content: " + name.equals(name4));
		
//		3. CREATE STRING FROM A CHARACTER ARRAY
		System.out.println("=================================================");
		System.out.println("3. CREATE STRING FROM A CHARACTER ARRAY");
		
		char arr[] = {'C','H','I','T','K','A','R','A'};
		String strFromArr = new String(arr); //Constructor Overloading
		System.out.println("strFromArr: " + strFromArr);
		
//		4. CREATE A PARTIAL STRING FROM A CHARACTER ARRAY
		System.out.println("=================================================");
		System.out.println("4. CREATE A PARTIAL STRING FROM A CHARACTER ARRAY");
		
		String partialStrFromArr = new String(arr, 4, 4); //passed the array, starting index, count of elements to be picked
		System.out.println("partialStrFromArr: " + partialStrFromArr);
		
		String partialStrFromArr2 = new String(arr,2,3);
		System.out.println("partialStrFromArr2: " + partialStrFromArr2);
		
//		5. CHANGING THE CASE
		System.out.println("=================================================");
		System.out.println("5. CHANGING THE CASE");
		
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		System.out.println(s1);
		
//		6. SPLITTING
		System.out.println("=================================================");
		System.out.println("6. SPLITTING");
		
		System.out.println("Please enter your full name: ");
		Scanner sc = new Scanner(System.in);
		String fullName = sc.nextLine();
		
		String strArr[] = fullName.split(" ");
		
		for(int i=0;i<strArr.length;i++)
		{
			System.out.println(strArr[i]);
		}
		
		String commaSeparated = "Elon,Musk,is,an,alien";
		String strArr2[] = commaSeparated.split(",");
		
		for(int i=0;i<strArr2.length;i++)
		{
			System.out.println(strArr2[i]);
		}
		
		String dotSeparated = "Hello.I.Am.A.Dot";
//		Dot is a meta expression in regex, so we have to put it in square brackets
		String strArr3[] = dotSeparated.split("[.]");
		
		for(int i=0;i<strArr3.length;i++)
		{
			System.out.println(strArr3[i]);
		}
		
//		7. LENGTH OF THE STRING
		System.out.println("=================================================");
		System.out.println("7. LENGTH OF THE STRING");
		
		System.out.println("Length of the string *" + s1 + "* is: " + s1.length());
		
//		8. FINDING INDEX OF A CHARACTER IN A STRING
		System.out.println("=================================================");
		System.out.println("8. FINDING INDEX OF A CHARACTER IN A STRING");
		
		int index = name.indexOf('a'); //returns the index of first occurrence of the character in the string
		System.out.println("Index of 'a' in " + name + " is: " + index);
		
		int index2 = name.indexOf('f'); //returns the index of first occurrence of the character in the string
		System.out.println("Index of 'f' in " + name + " is: " + index2);
		
		int index3 = name.indexOf("kara"); //returns the index of first occurrence of the String
		System.out.println("Index of 'kara' in " + name + " is: " + index3);
		
		int index4 = name.indexOf('a', 6); //start the search from index 6[included]
		System.out.println("Second occurrence index of 'a' in " + name + " is: " + index4);
		
		//FIND ALL OCCURRENCE OF A CHARACTED IN A STRING -> ignore the case
		System.out.println("==============FINDING ALL OCCURRENCES==============");
		String s = "KNOWLEDGE";
		char c = 'e';
		printAllOccurrences(s,c);
		
//		9. EXTRACTING A SUBSTRING
		System.out.println("=================================================");
		System.out.println("9. EXTRACTING A SUBSTRING");
		
		String wF = "Wakanda Forever";
		System.out.println(wF.substring(3)); //From starting pick string till end
		System.out.println(wF.substring(3,7)); //From starting pick string till end index(excluded)
		
//		10. FINDING A CHARACTER AT A GIVEN INDEX
		System.out.println("=================================================");
		System.out.println("10. FINDING A CHARACTER AT A GIVEN INDEX");
		
		System.out.println(name.charAt(0));
		System.out.println(name.charAt(5));
//		System.out.println(name.charAt(10)); //EXCEPTION if index given >=LENGTH
		
		char charAtIndex = name.charAt(6);
		System.out.println(charAtIndex);
		
//		11. Char array from String
		System.out.println("=================================================");
		System.out.println("11. Char array from String");
		
		char charArr[] = name.toCharArray();
		for(int i=0;i<charArr.length;i++)
		{
			System.out.println(charArr[i]);
		}
		
//		12. Check if string is empty
		System.out.println("=================================================");
		System.out.println("12. Check if string is empty");
		
		String emptyString = new String();
		String emptyString2 = "";
		String blankString = "    ";
		
		System.out.println(emptyString.equals(""));
		System.out.println(emptyString2.equals(""));
		System.out.println(emptyString2.equals(emptyString));
		
		System.out.println(emptyString.isEmpty());
		System.out.println(emptyString2.isEmpty());
		System.out.println(blankString.isEmpty());
		
		System.out.println(emptyString.isBlank());
		System.out.println(emptyString2.isBlank());
		System.out.println(blankString.isBlank());
		
//		13. Compare Strings LEXICOGRAPHICALLY -> alphabetically -> dictionary order
		System.out.println("=================================================");
		System.out.println("13. Compare Strings LEXICOGRAPHICALLY -> alphabetically");
		
		String textOne = "AD"; //compares CHARACTER BY CHARACTER
		String textTwo = "A";
		System.out.println(textOne.compareTo(textTwo));
		System.out.println(textTwo.compareTo(textOne));
		System.out.println(textOne.compareTo(textOne));
		
//		14. Trimming White Spaces from front and end 
		System.out.println("=================================================");
		System.out.println("14. Trimming White Spaces from front and end");
		
		String s4 = "Hello    ";
		String s5 = "       Hello               ";
		String s6 = "        Hello    People         ";
		
		System.out.println(s4.trim());
		System.out.println(s5.trim());
		System.out.println(s6.trim());
		
//		15. Replacing a character
		System.out.println("=================================================");
		System.out.println("15. Replacing a character");
		
		System.out.println(s1.replace('l', 'L'));
		System.out.println(s1.replace("el", ".E.L."));
 		
	}

}
