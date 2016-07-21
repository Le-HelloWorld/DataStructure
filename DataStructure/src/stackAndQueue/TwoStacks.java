package stackAndQueue;

import java.util.ArrayList;
import java.util.Stack;

public class TwoStacks {
	
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
		Stack<Integer> stack = new Stack<Integer>();
		// push data to stack
		for (int i = numbers.length - 1; i >= 0; i--) {
			stack.add(numbers[i]);
		}
		
		return sortStackByStack(stack);		
    }
	
	public ArrayList<Integer> sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int cur = 0;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			while (!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
		
		// write to ArrayList
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		
		return result;
	}
	
	@org.junit.Test
	public void test() {
		int[] test = {1,2,3,4,5};
		ArrayList<Integer> r = twoStacksSort(test);
		for (int i = 0; i < r.size(); i++) {
			System.out.println(r.get(i));
		}
	}
	
}
