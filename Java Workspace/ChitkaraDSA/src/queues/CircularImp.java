package queues;

class CircularQueue {
	int size = 10;
	int arr[] = new int[size];
	int front = -1;
	int rear = -1;

	boolean isEmpty() {
		return (front == -1 && rear == -1);
	}

	int peek() {

		if (this.isEmpty()) {
			System.out.println("Empty Queue, Nothing at front.");
			return -1;
		}

		return arr[front];
	}

	void enqueue(int data) {

		if (this.isEmpty()) // when queue is empty
		{
			front++;
		}

		else if (front == (rear + 1) % size) // when queue is full
		{
			System.out.println("Queue is Full! Cannot Enqueue.");
			return;
		}

		rear = (rear + 1) % size;
		arr[rear] = data;
	}

	int dequeue() {

		if (this.isEmpty()) {
			System.out.println("Empty Queue, Nothing to Dequeue.");
			return -1;
		}

		if (front == rear) // Deleting the only element left in the queue
		{
			int temp = arr[front];
			front = -1;
			rear = -1;
			return temp;
		}

		int temp = arr[front];
		front = (front + 1) % size;
		return temp;
		
	}
}

public class CircularImp {

	public static void main(String[] args) {
		CircularQueue q = new CircularQueue();
//		System.out.println(q.peek());
//		System.out.println(q.isEmpty());
//		q.enqueue(5);
//		System.out.println(q.isEmpty());
//		System.out.println(q.peek());
//		System.out.println(q.dequeue());
//		System.out.println(q.isEmpty());

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		q.enqueue(9);
		q.enqueue(10);

		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

		q.enqueue(11);
		q.enqueue(12);
		q.enqueue(13);
		
		q.enqueue(14);
	}

}
