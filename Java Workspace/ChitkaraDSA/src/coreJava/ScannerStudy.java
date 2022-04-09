package coreJava;

import java.util.Scanner;

public class ScannerStudy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter your full name: ");
		String firstName = sc.next();
		String lastName = sc.next();
		System.out.println("Please enter your Profession: ");
		String profession = sc.next();
		System.out.println("Please enter your address: ");
//		sc.nextLine(); //Taking cursor to the next line to take inputs correctly
		String address = sc.nextLine();
		System.out.println("Please enter your House Number: ");
		int hNo = sc.nextInt();
		
		System.out.println("***************************************");
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);
		System.out.println("Profession: " + profession);
		System.out.println("Address: " + address);
		System.out.println("House Number: " + hNo);
		
//		Whenever we have mixed inputs like:
//		1. Mixture of different datatypes [int, String]
//		2. Picking up single words or picking up whole sentences
//		Use sc.nextLine() -> for words as well as for other data types
//		Parse and Split the data if required
	}

}
