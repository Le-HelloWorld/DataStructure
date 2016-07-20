package stackAndQueue;

public class StackByLink<E> {
	
	
	
	Node<E> top = null;
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(E data) {
		Node<E> newNode = new Node<E>(data);
		newNode.next = top;
		top = newNode;
		
	}
	
	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		
		E data = top.data;
		top = top.next;
		return data;
		
	}
	
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}
	
		
	public static void main(String[] args) {
		StackByLink<Integer> s = new StackByLink<Integer>();
		s.push(1);
		s.push(2);
		System.out.println("top is: " + s.pop());
		System.out.println("top is: " + s.pop());
	}

}
