package arrays;

public class RandomNumber {

	public static void main(String[] args) {
		double x = Math.random(); //gives a random number between [0,1]
		int min = 5;
		int max = 10;
		int range = max - min + 1;
		
//		x*range -> [0,range]
//		X*range + min -> [min, min + range]
		
		double random = x*range + min;
		//(int)(Math.random()*(max-min+1) + min)
		int r = (int) random;
		System.out.println("Random Number: " + r);
		
	}

}
