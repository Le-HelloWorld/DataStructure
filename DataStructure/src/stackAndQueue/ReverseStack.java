package stackAndQueue;

import java.util.Stack;

/**
 * 只利用递归函数把一个stack逆序且不能使用额外的数据结构
 * 这里利用两个递归函数,一个递归把栈底元素弹出并返回,另一个逆反
 * @author lewang
 *
 */

public class ReverseStack {
	
	public int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.empty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}
	
	public void reverse(Stack<Integer> stack) {
		if (stack.empty()) {
			return;
		} else {
			int i = getAndRemoveLastElement(stack);
			reverse(stack);
			stack.push(i);
		}
	}
	
	@org.junit.Test
	public void test() {
		int[] test = {289,435,175,336,432,455,4};
		//int[] test2 = {1, 2, 3, 4, 5, 6, 7 , 8 ,9, 10};
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = test.length - 1; i >= 0; i--) {
			stack.add(test[i]);
		}
	    reverse(stack);
		while (!stack.empty()) {
			System.out.println(stack.pop());
		}
	}
	

}
