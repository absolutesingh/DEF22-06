package priorityQueuesAndHeaps;

class PQUsingArray {
	final int capacity = 10;
	int arr[] = new int[capacity];// Size of the array
	int size = 0; // Number of items in the PQ at any particular time.

	void add(int data) {

		if (size == capacity) {
			System.out.println("Cannot add, PQ is full!");
			return;
		}

		if (this.isEmpty()) {
			arr[0] = data;
			size++;
			return;
		}

		int i;

		for (i = size - 1; i >= 0; i--) {
			if (data > arr[i])// reverse this condition to toggle between Min and Max Priority Queue
			{
				arr[i + 1] = arr[i];
			} else {
				// we have found the smaller element in the array
				break;
			}
		}

		arr[i + 1] = data; // To handle the case where insertion happens at index 0.
		size++; // As we have added a new element
	}

	int poll() {
		if (this.isEmpty()) {
			System.out.println("Nothing to poll, PQ is empty!");
			return -1;
		}

		return arr[--size];
	}

	int peek() {
		if (this.isEmpty()) {
			System.out.println("Nothing to peek, PQ is empty!");
			return -1;
		}
		return arr[size - 1];
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}
}

public class ArrayImpl {

	public static void main(String[] args) {
		PQUsingArray pq = new PQUsingArray();
		System.out.println(pq.isEmpty());
		System.out.println(pq.size());
		pq.add(3);
		pq.add(4);
		pq.add(1);
		pq.add(9);
		pq.add(5);
		pq.add(7);
		System.out.println(pq.isEmpty());
		System.out.println(pq.size());
		System.out.println(pq.peek());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.size());
	}

}
