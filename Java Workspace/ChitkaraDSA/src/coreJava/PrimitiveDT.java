package coreJava;

public class PrimitiveDT {

	public static void main(String[] args) {
		//Java is not a purely object oriented programing language because we have primitive data types which are not objects.
		//We can create objects from them using Wrapper Classes -> Integer, Float, Double etc.
		
		int a = 5;
		System.out.println("A is: " + a);
		
		byte b = 10;
		System.out.println("B is: " + b);
		
		int i = b; //Implicit type casting or Up-Casting or Widening
		System.out.println("I is: " + i);
		
		int c = 256;
		
		byte b2 = (byte)c;
		System.out.println("B2 is: " + b2);
		
		int p = 5;
		int q = p++; //Post increment operator [assign then increment]
		System.out.println("p is: " + p);
		System.out.println("q is: " + q);
		
		int m = 5;
		int n = ++m; //Pre increment operator [increment then assign]
		System.out.println("m is: " + m);
		System.out.println("n is: " + n);
	}

}
