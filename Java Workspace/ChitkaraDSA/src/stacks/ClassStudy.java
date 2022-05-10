package stacks;
import java.util.Stack;

public class ClassStudy {
	
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		System.out.println(stack.isEmpty());
		stack.push(1);
		stack.push(2);
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		System.out.println(stack.pop());
		System.out.println(stack.size());
	}
	
}
