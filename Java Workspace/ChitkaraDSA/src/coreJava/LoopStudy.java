package coreJava;

public class LoopStudy {

	public static void main(String[] args) {
//		System.out.println("1");
//		System.out.println("2");
//		System.out.println("3");
		
		//FOR Loop
		int i;
		for(i=1;i<=100;i++)
		{
			System.out.println(i);
		}
		
		System.out.println("Value of i after FOR loop is: " + i);
		
		//WHILE Loop
		int n = 5;
		while(n>0)//Keep on working till
		{
			System.out.println("N is: " + n);
			n--;
		}
		System.out.println("Value of n after WHILE loop is: " + n);
		
		//DO WHILE Loop
		int m = 5;
		do
		{
			System.out.println("M is: " + m);
			m--;
		}
		while(m>0);
		
		System.out.println("Value of m after WHILE loop is: " + m);
		
		//WHAT IS THE DIFFERENCE BETWEEN WHILE AND DO WHILE LOOP?
		
		n = 0;
		while(n>0)//Keep on working till
		{
			System.out.println("N is: " + n);
			n--;
		}
		System.out.println("Value of n after WHILE loop is: " + n);
		
		//DO WHILE Loop -> It will execute the set of statements atleast once
		m = 0;
		do
		{
			System.out.println("M is: " + m);
			m--;
		}
		while(m>0);
		
		System.out.println("Value of m after WHILE loop is: " + m);
		
		//FOREACH loop or Enhanced FOR Loop
	}

}
