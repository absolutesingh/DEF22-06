package stacks;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
public class EvaluatePostfix {
	static int process(int left, int right, char operator) {
		switch (operator) {
		case '*':
			return left * right;

		case '/':
			return left / right;

		case '+':
			return left + right;

		case '-':
			return left - right;

		default:
			return -1; // our code will never reach here
		}
	}

	// Function to evaluate a postfix expression.
	public static int evaluatePostFix(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// If Operand
			if (Character.isDigit(c)) {
				stack.push(c - '0');
			} else { // operator
				int right = stack.pop();
				int left = stack.pop();
				int res = process(left, right, c);
				stack.push(res);
			}
		}

		return stack.pop();
	}
}