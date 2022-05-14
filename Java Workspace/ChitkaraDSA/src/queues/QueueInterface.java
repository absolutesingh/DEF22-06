package queues;

import java.util.*;

public class QueueInterface {

	public static void main(String[] args) {
		//Interface -> Queue
		//Jave provides implementation of Queues using Linked List
		
		Queue<Integer> q = new LinkedList<>();
		
		System.out.println(q.isEmpty());
		
		q.add(1);
		q.add(2);
		q.add(3);
		
		System.out.println(q.isEmpty());
		
		System.out.println(q.poll()); //poll means dequeue
		System.out.println(q.peek());
		System.out.println(q.isEmpty());
		
		
	}

}
