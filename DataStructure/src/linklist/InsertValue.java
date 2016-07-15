package linklist;

/**
 * 环形链表插入值
 * @author lewang
 *
 */

public class InsertValue {
	
	/**
	 * 插入方法
	 * @param A
	 * @param nxt
	 * @param val
	 * @return 返回HEAD元素
	 */
	public ListNode insert(int[] A, int[] nxt, int val) {
		/*
		 * 先判断A是否为空,如果空,说明是空的环形链表,val 自己连接自己
		 */
		if (A == null || A.length == 0) {
			ListNode t = new ListNode(val);
			t.next = t;
			return t;
		}
		
		/*
		 * 构建环形链表
		 */
		ListNode head = new ListNode(A[0]);
		ListNode last = null;
		ListNode r = head;
		ListNode p = null;
		
		for (int i = 0; i < nxt.length - 1; i++) {
			p = new ListNode(A[nxt[i]]);
			r.next = p;
			r = p;
		}
		p.next = head;
		last = p; // 标记last;
		
		/*
		 * 插入数值,用2个节点与该值比较,如果大于前面,小于后面,则插入
		 * 特殊情况值比所有值都小,插入首位变HEAD, 如果比所有值都大,插入LAST
		 */
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode t = new ListNode(val);
		int count = 0; // 计数器,环形链表,有多少个节点有多少个线段
		
		/*
		 * 首先判断它是否比头小,或者比尾大
		 */
		if (val < head.val || val > last.val) {
			t.next = head;
			last.next = t;
		}

		while (count < A.length - 1) {
			if (val <= cur.val && val >= pre.val) {
				t.next = cur;
				pre.next = t;
				break;
			} 
			pre = cur;
			cur = cur.next;
			count++;
		}
	
		if (t.val < head.val) {
			return t;
		} else {
			return head;
		}        
    }
	public ListNode insert2(int[] A, int[] nxt, int val) {
        if(A== null || A.length == 0){
            ListNode t= new ListNode(val);
            return t;
            
        }
        
        
        
    ListNode head = new ListNode(A[0]);
    ListNode r=head;
    ListNode p;
    for(int i=0;i<nxt.length-1;i++)
    {
        p=new ListNode(A[nxt[i]]);
        r.next=p;
        r=p;
    }

        
        
        
        
        
        ListNode pos = head;
        ListNode pas = head.next;
        while(pas!=null){
            if(val >=pos.val&&val<= pas.val)
                break;
            pos =pas;
            pas = pas.next;
        }
        ListNode t= new ListNode(val);
        t.next =pas;
        pos.next=t;
        if(val<head.val)
            return t;
        else
            return head;
            
    }	
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	@org.junit.Test
	public void Test() {
/*

int A[] = {3,5,9,11,14,17,20,20,24,27,31,32,36,38,40,41,44,45,48,51,55,56,56,58,61,65,69,72,74,76,76,80,84,88,89,89,92,96,97,98,98,98,101,103,103,106,108,108,110,114,117,120,121,125,129,130,130,132,136,136,138,142,146,150,151,153,153,157,161,165,168,172,173,176,178,180,183,185,188,188,188,191,193,195,198,199,202,204,206,208,209,211,215,218,218,222,223,225,228,232,235,239,240,241,243,247,251,254,255,255,258,258,262,265,267,267,268,272,276,276,278,282,284,287,288,292,292,294,297,300,300,301,303,306,306,309,311,313,316,317,320,322,326,327,330,330,333,335,339,339,339,340,343,346,346,348,348,348,349,351,352,356,358,359,360,363,364,368,371,375,379,379,380,384,388,390,391,393,394,395,399,403,405,406,407,409,409,410,414,414,417,419,422,426,427,431,432,435,435,436,439,443,444,445,446,449,453,457,458,460,461,462,466,469,473,474,477,478,479,480,480,480,483,486,486,487,490,493,496,498,499,500,501,504,507,511,513,514,518,518,522,524,526,527,531,535,536,540,540,543,546,549,551,552,554,555,559,562,566,570,573,574,576};
int nxt[] ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,219,220,221,222,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254,255,256,257,258,259,260,261,262,0};
int val = 595;
*/
		int[] A = {1,3,4,5,7};
	    int[] nxt = {1,2,3,4,0};
	    int val = 0;
	    
	    ListNode list = insert2(A, nxt,val);
	    ListNode head = list; // 标记head,打印环形链表
	   	do {
	    	System.out.print(list.val+ " ");
	    	list = list.next;
	    }while (!list.equals(head));
	    System.out.println();
	    
	}

}
