package stack;

public class GetMin {
	
	StackByLink<Integer> stackData;
	StackByLink<Integer> stackMin;
	
	public GetMin() {
		stackData = new StackByLink<Integer>();
		stackMin = new StackByLink<Integer>();
	}
	
	public void push(int data) {
		stackData.push(data);
		
		if (stackMin.isEmpty()) {
			stackMin.push(data);
		} else {
			if (data < stackMin.peek()) {
				stackMin.push(data);
			}
		}
		
	}
	
	public int pop() {
		int top = stackData.pop();
		if (top == stackMin.peek()) {
			stackMin.pop();
		}
		return top;
	}
	
	public int getMin() {
		if (stackMin.isEmpty()) {
			return Integer.MAX_VALUE;
		}
		return stackMin.peek();
	}
	
	@org.junit.Test
	public void test() {
		GetMin getmin = new GetMin();
		int[] test = {6, 20, 5, 3, 4, 1};
		for (int i = 0; i < test.length; i++) {
			getmin.push(test[i]);
		}
		System.out.println(getmin.getMin());
		getmin.pop();
		getmin.pop();
		getmin.pop();
		getmin.pop();
	    getmin.pop();
		System.out.println(getmin.getMin());
	}
	
	

}
