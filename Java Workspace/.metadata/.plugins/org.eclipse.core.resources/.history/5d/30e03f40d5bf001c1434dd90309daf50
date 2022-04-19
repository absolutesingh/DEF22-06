package arrays;

import java.util.Scanner;

public class ArtisticPattern {
	
	static void printFirstOrLastRow(int n)
	{
		System.out.print("+");
		for(int i=0;i<2*n;i++)
		{
			System.out.print("-");
		}
		System.out.println("+");
	}
	
	static void printUpperHalf(int n)
	{
		for(int i=0;i<n-1;i++) //n-1 rows in the upper half
		{
			System.out.print("|");
			
			for(int j=0;j<n-1-i;j++)
			{
				System.out.print(" ");
			}
			
			System.out.print("/");
			
			for(int j=0;j<2*i;j++)
			{
				if(i%2==0)
				{
					System.out.print("=");
				}
				else {
					System.out.print("-");
				}
			}
			
			System.out.print("\\"); //escape character
			
			for(int j=0;j<n-1-i;j++)
			{
				System.out.print(" ");
			}
			
			System.out.println("|");
		}
	}
	
	static void printMiddleRow(int n)
	{
		System.out.print("|<");
		
		for(int i=0;i<2*n-2;i++)
		{
			if(n%2==0)
			{
				System.out.print("-");
			}
			else {
				System.out.print("=");
			}
		}
		
		System.out.println(">|");
	}
	
	static void printLowerHalf(int n)
	{
		for(int i=0;i<n-1;i++) //n-1 rows in the upper half
		{
			System.out.print("|");
			
			for(int j=0;j<i+1;j++)
			{
				System.out.print(" ");
			}
			
			System.out.print("\\"); //escape character
			
			for(int j=0;j<2*(n-i-2);j++)
			{
				if(i%2==0)
				{
					System.out.print("-");
				}
				else {
					System.out.print("=");
				}
			}
			
			System.out.print("/"); 
			
			for(int j=0;j<i+1;j++)
			{
				System.out.print(" ");
			}
			
			System.out.println("|");
		}
	}
	
	static void printArtisticPattern(int n)
	{
		printFirstOrLastRow(n);
		printUpperHalf(n);
		printMiddleRow(n);
		printLowerHalf(n);
		printFirstOrLastRow(n);
	}

	public static void main(String[] args) {
		System.out.print("Please enter the size of art you want: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		printArtisticPattern(n);
	}

}
