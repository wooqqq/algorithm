package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class p1918 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		Map<Character, Integer> priority = new HashMap<>();

		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			if ('A' <= c && c <= 'Z') {
				postfix += c;
			} else if (c == '(') {
				stack.push(c);
			} else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix += stack.pop();
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && priority.get(c) <= priority.get(stack.peek())) {
					postfix += stack.pop();
				}
				stack.push(c);
			}
		}
		
		while (!stack.isEmpty()) {
			postfix += stack.pop();
		}

		System.out.println(postfix);
	}
}
