package stacks;

import java.util.Stack;

public class SortAStack {

	static Stack<Integer> st = new Stack<>();
	
	static void sortedInsert(int data)
	{
		if(st.isEmpty() || data>st.peek())
		{
			st.push(data);
			return;
		}
		
		int temp = st.pop();
		sortedInsert(data);
		st.push(temp);
	}
	
	static void sortAStack()
	{
		if(st.size() <= 1) 
			return;
		
		int temp = st.pop();
		sortAStack();
		sortedInsert(temp);
	}

	public static void main(String[] args) {
		st.push(1);
		st.push(0);
		st.push(5);
		st.push(2);
		st.push(6);

		System.out.println("Stack before sorting: ");
		System.out.println(st);

		sortAStack();

		System.out.println("Stack after sorting: ");
		System.out.println(st);
	}

}
