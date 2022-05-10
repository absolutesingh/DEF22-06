package stacks;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/valid-expression1025/1/
public class BalancedParenthesis {
	static boolean isPair(char a, char b) {
		if (a == '[' && b == ']')
			return true;
		if (a == '{' && b == '}')
			return true;
		if (a == '(' && b == ')')
			return true;
		return false;
	}

	boolean valid(String s) {
		int len = s.length();
		if (len % 2 != 0)
			return false; // odd

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (c == '[' || c == '(' || c == '{') // if opening character
			{
				stack.push(c);
			} else {
				if (stack.isEmpty())
					return false;

				if (isPair(stack.peek(), c)) // (opening, closing)
				{
					stack.pop();
				} else {
					return false;
				}
			}
		}

		// reached the end of string
		if (!stack.isEmpty())
			return false;

		return true;
	}
}
