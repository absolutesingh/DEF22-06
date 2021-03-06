package coreJava;

public class ControlFlow {

	static void findMax(int a, int b, int c)
	{
		if(a>b) // Nested If-else
		{
			if(a>c)
			{
				System.out.println("A is the largest: " + a);
			}
			else//c>a
			{
				System.out.println("C is the largest: " + c);
			}
		}
		else//b>a 
		{
			if(b>c)
			{
				System.out.println("B is the largest: " + b);
			}
			else//c>b
			{
				System.out.println("C is the largest: " + c);
			}
		}
	}
	
	public static void main(String[] args) {
		int num = 50;
		if(num>50)
		{
			System.out.println("Passed");
		}
		else {
			System.out.println("Failed");
		}
		
		findMax(15,10,20);
		
		char c ='d';
		
		switch(c) //H.W. -> What all data types are supported by switch case?
		{
		case 'a':
			System.out.println("Hi, I'm A");
			break;
		case 'b':
			System.out.println("Hi, I'm B");
			break;
		case 'c':
			System.out.println("Hi, I'm C");
			break;
		default:
			System.out.println("I'm not A, B or C");
		}
	}

}
