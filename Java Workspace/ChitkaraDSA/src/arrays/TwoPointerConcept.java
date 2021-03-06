package arrays;

public class TwoPointerConcept {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 35, 50, 75, 80 };
		int sum = 65;

		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			int mySum = arr[l] + arr[r];

			if (sum == mySum) {
				System.out.println("Elements at index: " + l + " and " + r + " sum to form " + sum);
				return;
			} else if (sum < mySum) {
				r--;
			} else {
				l++;
			}
		}

		System.out.println("No elements in the array sum up to " + sum + ".");
	}

}
