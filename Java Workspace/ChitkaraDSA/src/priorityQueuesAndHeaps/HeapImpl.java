package priorityQueuesAndHeaps;

class MyHeap {
//	Array Implementation of a Complete Binary Tree
	final int capacity = 10;// Size of the array
	int arr[] = new int[capacity];
	int size = 0;// Number of items in the PQ at any particular time.

//	-------------------SOME UTILITY FUNCTIONS-------------------

//	FUNCTIONS TO GET INDEXES
	int getParentIndex(int i) {
		return (i - 1) / 2;
	}

	int getLeftChildIndex(int i) {
		return 2 * i + 1;
	}

	int getRightChildIndex(int i) {
		return 2 * i + 2;
	}

//	FUNCTIONS TO CHECK IF THE PARENT/CHILDREN EXIST
	boolean hasParent(int i) {
		return getParentIndex(i) >= 0;
	}
	
	boolean hasLeftChild(int i) {
		return getLeftChildIndex(i) < size; //That index must exist in our array
	}
	
	boolean hasRightChild(int i) {
		return getRightChildIndex(i) < size; //That index must exist in our array
	}
	
//	FUNCTIONS TO GET THE VALUE OF THE PARENT/CHILDREN
	int getParentValue(int i)
	{
		return arr[getParentIndex(i)];
	}
	
	int getLeftChildValue(int i)
	{
		return arr[getLeftChildIndex(i)];
	}
	
	int getRightChildValue(int i)
	{
		return arr[getRightChildIndex(i)];
	}

//	------------------------------------------------------------
	
	int peek() {
		if (this.isEmpty()) {
			System.out.println("Nothing to peek, PQ is empty!");
			return -1;
		}
		return arr[0]; //Highest priority element is at root
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}

	// Insertion in heaps
	void add(int data) {
		if (size == capacity) // If heap is full
		{
			if (size == capacity) {
				System.out.println("Cannot add, Heap is full!");
				return;
			}
		}

		arr[size++] = data; // Place the elemetn at index size and then increment size by 1
//		size++;

		heapifyUp();
	}

	void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) && getParentValue(index) < arr[index]) {
			swap(getParentIndex(index), index); // Swap parent and child through their indexes
			index = getParentIndex(index);
		}
	}
	
	void swap(int index1, int index2)
	{
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
}

public class HeapImpl {

	public static void main(String[] args) {
		MyHeap heap = new MyHeap();
		System.out.println(heap.isEmpty());
		System.out.println(heap.size());
		heap.add(3);
		heap.add(4);
		heap.add(1);
		heap.add(9);
		heap.add(5);
		heap.add(7);
		System.out.println(heap.isEmpty());
		System.out.println(heap.size());
		System.out.println(heap.peek());
	}

}
