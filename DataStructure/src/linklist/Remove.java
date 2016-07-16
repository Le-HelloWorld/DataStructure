package linklist;

/**
 * 给定一个链表中的节点node, 但不给定整个链表的头节点,如何在链表中删除node? 要求算法复杂度为O(1)
 * 双链表很容易
 * 单链表- 删除某个节点(非尾节点)只需要把该节点下一个节点的值赋值给该节点,然后删除下一个节点即可
 * @author lewang
 *
 */

public class Remove {
	
	public boolean removeNode(ListNode pNode) {
		
		// 判定是否是最后一个节点
		if (pNode.next == null) {
			return false;
		} else {
			pNode.val = pNode.next.val;
			pNode.next = pNode.next.next;	
		}
		return true;
		
	}
	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	@org.junit.Test
	public void test() {
		int[] A = {1, 2, 3, 4, 5};
		ListNode head = new ListNode(A[0]);
		ListNode r = head;
		ListNode p = null;
		for (int i = 1; i < A.length; i++) {
			p = new ListNode(A[i]);
			r.next = p;
			r = p;
		}
		ListNode pNode = head.next.next;
		removeNode(pNode);
		ListNode cur = head;
		do {
			System.out.print(cur.val + " ");
			cur = cur.next;
		} while (cur != null);
	}
	

}
