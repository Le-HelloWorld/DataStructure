package stackAndQueue;

import java.util.Stack;

/**
 * 利用两个栈实现一个队列的操作
 * 思路:一个栈作为PUSH,一个栈作为POP
 * 
 * 满足条件:
 *   1. 如果push stack要往pop stack中压入数据,必须一次性把stack push中的数据全部压入
 *   2. 如果pop stack不为空 , push stack绝对不能向pop stack压入数据
 * @author lewang
 *
 */

public class TwoStackQueue {
	
	Stack<Integer> stackPush = new Stack<Integer>();
	Stack<Integer> stackPop = new Stack<Integer>();
	
	public void add(int pushInt) {
		stackPush.push(pushInt);
	}
	
	public int poll() {
		if (stackPush.empty() && stackPop.empty()) {
			System.out.println("The Queue is empty !");
		} else if (stackPop.empty()){
			while( !stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	
	public int peek() {
		if (stackPush.empty() && stackPop.empty()) {
			System.out.println("The Queue is empty !");
		} else if (stackPop.empty()){
			while( !stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
	
	public boolean empty() {
		return stackPop.empty();
	}
	
	@org.junit.Test
	public void test() {
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TwoStackQueue q = new TwoStackQueue();
		for (int i = 0; i < test.length; i++) {
			q.add(test[i]);
		}
		do{
			System.out.print(q.poll() + " ");
			//top = q.poll();
		} while (!q.empty());
		
	}
	
	

}
