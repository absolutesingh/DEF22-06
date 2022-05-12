package stacks;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1/
public class MinStack {
	int minEle;
	Stack<Integer> s = new Stack<>();

	/* returns min element from stack */
	int getMin() {
		if (s.isEmpty())
			return -1;
		return minEle;
	}

	/* returns poped element from stack */
	int pop() {
		if (s.isEmpty())
			return -1;

		int x = s.pop();

		if (x >= minEle) {
			return x;
		}

		else {
			int temp = minEle;
			minEle = 2 * minEle - x; // decoding while popping
			return temp;
		}
	}

	/* push element x into the stack */
	void push(int x) {
		if (s.isEmpty()) {
			s.push(x);
			minEle = x;
			return;
		}

		if (x >= minEle) {
			s.push(x);
		} else {
			s.push(2 * x - minEle); // encoding while pushing
			minEle = x;
		}
	}
}