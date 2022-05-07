package linkedList;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class MyLL {

	static void print(Node head)// Copy of reference passed
	{
		if (head == null) {
			System.out.println("Empty LL: Nothing to print.");
			return;
		}

		while (head != null)// fine to use head over here as it is copy of reference
		// Original head is preserved in Main
		{
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	static Node insertAtHead(Node head, int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		return newNode;
//		head = newNode;
//		return head;
	}

	static Node insertAtEnd(Node head, int data) {
		Node newNode = new Node(data);

		if (head == null) // Explicitly Handling -> if LL is empty
		{
			return newNode;
		}

		Node last = head;
		while (last.next != null) {
			last = last.next;
		}
		// last element found
		last.next = newNode;
		return head;
	}

//	https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1/
	static int getMiddle(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return slow.data;
	}

//	https://practice.geeksforgeeks.org/problems/merge-two-sorted-linked-lists/1
	static Node sortedMerge(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		Node newHead;

		if (head1.data <= head2.data) {
			newHead = head1;
			head1 = head1.next;
		} else {
			newHead = head2;
			head2 = head2.next;
		}

		Node last = newHead;

		while (true) {
			if (head1 == null) {
				last.next = head2;
				break;
			}
			if (head2 == null) {
				last.next = head1;
				break;
			}

			if (head1.data <= head2.data) {
				last.next = head1;
				head1 = head1.next;
			} else {
				last.next = head2;
				head2 = head2.next;
			}

			last = last.next; // in any case

		}

		return newHead;

	}

//	https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1/#
	Node mergeKList(Node[] arr, int K) {
		int l = 0;
		int r = K - 1;

		while (r != 0) {
			arr[l] = sortedMerge(arr[l], arr[r]);
			l++;
			r--;
			if (l >= r) {
				l = 0;
			}
		}

		return arr[0];
	}

//	https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1/
	Node reverseList(Node head) {
		if (head == null)
			return head;

		Node prev = null;
		Node next = null;
		Node current = head;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;

		// head = prev;
		// return head;
	}

//	https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1#
	static int intersectPoint(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null) {
			while (temp2 != null) {
				if (temp1 == temp2)
					return temp1.data;

				temp2 = temp2.next;
			}
			// temp2 becomes null
			temp2 = head2;
			temp1 = temp1.next;
		}
		// temp1 becomes null
		return -1;
	}

//	https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1#
	int intersectPointOptimized(Node head1, Node head2) {
		int len1 = 0;
		int len2 = 0;
		int diff = 0;

		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null) {
			temp1 = temp1.next;
			len1++;
		}

		while (temp2 != null) {
			temp2 = temp2.next;
			len2++;
		}

		// we've found the len of both LL's

		if (len1 >= len2) {
			temp1 = head1; // always naming the longer as 1
			temp2 = head2; // always naming the shorter as 2
			diff = len1 - len2;
		} else {
			temp1 = head2; // always naming the longer as 1
			temp2 = head1; // always naming the shorter as 2
			diff = len2 - len1;
		}

		// moving the longer one ahead by diff
		for (int i = 0; i < diff; i++) {
			temp1 = temp1.next;
		}

		while (temp1 != null && temp2 != null) {
			if (temp1 == temp2)
				return temp1.data;

			temp1 = temp1.next;
			temp2 = temp2.next;
		}

		return -1;
	}

//	https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1#
	static boolean detectLoop(Node head) {
		if (head == null)
			return false;

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) // order of this check matters
				return true;
		}

		return false;
	}

	void removeLoopApproach1(Node Node, Node loopNode) {
		Node temp = loopNode;
		while (true) // to move Node
		{
			while (Node.next != loopNode.next && loopNode.next != temp)// to move loopNode
			{
				loopNode = loopNode.next;
			}
			// it could have broken due to 2 reason
			if (Node.next == loopNode.next) {
				loopNode.next = null;
				return;
			}
			Node = Node.next;
		}
	}

//	https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1#
	public static void removeLoop(Node head) {
		if (head == null)
			return;

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) // order of this check matters
				removeLoopUtil(head, fast);
		}

		return;
	}

	static void removeLoopUtil(Node head, Node fast) {
		Node slow = head;

		if (slow == fast) // For circular linked list
		{
			while (fast.next != slow) {
				fast = fast.next;
			}
			fast.next = null;
			return;
		}

		// For all other cases
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
	}

//	https://leetcode.com/problems/add-two-numbers/submissions/
	Node addTwoNumbers(Node l1, Node l2) {

		Node result = null;
		Node curr = result;
		int carry = 0;

		while (!(l1 == null && l2 == null)) {
			int a = (l1 == null) ? 0 : l1.data;
			int b = (l2 == null) ? 0 : l2.data;
			int sum = a + b + carry;
			carry = sum / 10;
			if (result == null) {
				result = new Node(sum % 10);
				curr = result;
			} else {
				curr.next = new Node(sum % 10);
				curr = curr.next;
			}
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry == 1) {
			curr.next = new Node(carry);
		}
		return result;
	}

//	https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1
	public Node pairwiseSwap(Node head) {
		if (head == null || head.next == null)
			return head;

		Node prev = head;
		Node curr = head.next;
		Node result = head.next;
		Node next = null;

		while (true) {
			next = curr.next;
			curr.next = prev;

			if (next == null || next.next == null) {
				prev.next = next;
				return result;
			}

			prev.next = next.next;
			prev = next;
			curr = prev.next;
		}
	}

	public static void main(String[] args) {
		Node head = new Node(5);
//		System.out.println(head.data);
//		System.out.println(head.next);
		Node second = new Node(6);
		head.next = second;
		Node third = new Node(7);
		second.next = third;
		Node fourth = new Node(8);
		third.next = fourth;
		Node fifth = new Node(9);
		fourth.next = fifth;

//		System.out.println(head.data);
//		System.out.println(head.next.data);
//		System.out.println(head.next.next.data);
//		System.out.println(head.next.next.next.data);
//		System.out.println(head.next.next.next.next.data);

//		while(head!=null)
//		{
//			System.out.println(head.data);
//			head = head.next;
//		}
//		head has become null -> NEVER LOOSE YOUR HEAD

		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

		print(head);
		print(null);

		head = insertAtHead(head, 4);
		print(head);

		insertAtEnd(head, 10);
		print(head);

		Node head2 = null;
		head2 = insertAtHead(head2, 1);
		print(head2);

		Node head3 = null;
		head3 = insertAtEnd(head3, 1);
		print(head3);

	}

}
