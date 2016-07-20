package stackAndQueue;

import java.util.Arrays;

/**
 * 利用数组,构建一个stack
 * @author lewang
 *
 */

public class StackByArray<E> {
	
	private Object[] stack;
	private int size;
	
	public StackByArray() {
		stack = new Object[10];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	@SuppressWarnings("unchecked")
	public E peek() {
		if (isEmpty()) {
			return null;
		} else {
			return (E)stack[size - 1];
		}
	}
	
	public E pop() {
		E e = peek();
		stack[size - 1] = null;
		size--;
		return e;
	}
	
	public E push(E item) {
		ensureCapacity(size + 1);
		stack[size++] = item;
		return item;
	}

	private void ensureCapacity(int size) {
		// TODO Auto-generated method stub
		int len = stack.length;
		if (size > len) {
			int newLen = 10;
			stack = Arrays.copyOf(stack, newLen);
		}
	}
	
	public static void main(String[] args) {
		StackByArray<Integer> s = new StackByArray<Integer>();
		s.push(1);
		s.push(2);
		System.out.println("Num of item : " + s.size);
		System.out.println("top is: " + s.pop());
		System.out.println("top is: " + s.pop());
	}

}
