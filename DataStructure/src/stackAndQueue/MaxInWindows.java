package stackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * @author lewang
 *
 */

public class MaxInWindows {
	
	public ArrayList<Integer> maxInWindows(int [] num, int size) {
		if (num == null || size < 1 || num.length < size) {
			return null;
		}
		
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		
		for (int i = 0; i < num.length; i++) {
			while (!qmax.isEmpty() && num[qmax.peekLast()] <= num[i]) {
				qmax.pollLast();
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - size) {
				qmax.pollFirst();
			}
			
			if (i >= size - 1) {
				arr.add(num[qmax.peekFirst()]);
			}
		}
		return arr;
        
    }
	
	@org.junit.Test
	public void test() {
		int[] test = { 4,3,5,4,3,3,6,7};
		int size = 3;
		ArrayList<Integer> result =maxInWindows(test, size);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
	}

}
