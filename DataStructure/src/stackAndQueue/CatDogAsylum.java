package stackAndQueue;

import java.util.*;

/**
 * 有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，第一种为直接收养所有动物中最早进入收容所
 * 的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。给定一个操作序列
 * int[][2] ope(C++中为vector<vector<int>>)代表所有事件。若第一个元素为1，则代表有动物进入收容所，
 * 第二个元素为动物的编号，正数代表狗，负数代表猫；若第一个元素为2，则代表有人收养动物，第二个元素若为0，
 * 则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。请按顺序返回收养的序列。
 * 若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。
 * from nowcoder
 *
 */

public class CatDogAsylum {
	private Queue<PetQueue> dogQ = new LinkedList<PetQueue>();
	private Queue<PetQueue> catQ = new LinkedList<PetQueue>();
	private long count = 0;
	
    public ArrayList<Integer> asylum(int[][] ope) {
        // write code here
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	for (int i = 0; i < ope.length; i++) {
    		int add = 0;
    		if (ope[i][0] == 1) {
    			add(ope[i][1]);
    		} else if (ope[i][0] == 2) {
    			if (ope[i][1] == 0) {
    				add = pollAll();
    				if (add != 0) {
    					result.add(add);
    				}		
    			} else if (ope[i][1] > 0) {
    				add = pollDog();
    				if (add != 0) {
    					result.add(add);
    				}	
    			} else if (ope[i][1] < 0) {
    				add = pollCat();
    				if (add != 0) {
    					result.add(add);
    				}	
    			}
    		}
    	}
    	return result;
    }
    
    /**
     * 判断type,为1加入dogQ,为-1加入catQ, 都在后面加入时间戳
     * @param type
     */
    public void add(int type) {
    	if (type > 0) {
    		dogQ.add(new PetQueue(type, count++));
    	} else if (type < 0) {
    		catQ.add(new PetQueue(type, count++));
    	}
    }
    
    /**
     * 收养计划0, 按顺序弹出猫狗,比较时间戳
     * @return 猫狗类型
     */
    public int pollAll() {
    	if (!dogQ.isEmpty() && !catQ.isEmpty()) {
    		if (dogQ.peek().getCount() < catQ.peek().getCount()) {
    			return dogQ.poll().getType();
    		} else {
    			return catQ.poll().getType();
    		}
    	} else if (!dogQ.isEmpty()) {
    		return dogQ.poll().getType();
    	} else if (!catQ.isEmpty()) {
    		return catQ.poll().getType();
    	} else {
    		return 0;
    	}
    }
    
    public int pollDog() {
    	if (!dogQ.isEmpty()) {
    		return dogQ.poll().getType();
    	} else {
    		return 0;
    	}
    }
    
    public int pollCat() {
    	if (!catQ.isEmpty()) {
    		return catQ.poll().getType();
    	} else {
    		return 0;
    	}
    }
    
    /**
     * 内部类,给每个类型的动物加一个时间戳
     * @author lewang
     *
     */
    class PetQueue {
    	private int type;
    	private long count;
    	
    	public PetQueue(int type, long count) {
    		this.type = type;
    		this.count = count;
    	}
    	
    	public long getCount() {
    		return count;
    	}
    	
    	public int getType() {
    		return type;
    	}
    	
    }
    
    @org.junit.Test
    public void test() {
    	//int[][] test = {{1,1},{1,-1},{2,0},{2,-1}, {2, -3}};
    	int[][] test2 = {{1,-5},{1,-1},{1,9},{1,9},{2,0},{2,1},{1,-8},{2,1},{1,-71},
    	{1,-92},{1,18},{1,91},{1,61},{2,-1},{1,-35},{1,95},{1,-49},
    	{1,9},{1,78},{2,0},{1,91},{1,-96},{2,-1},{2,0},{2,-1},{2,1},
    	{1,38},{2,0},{1,45},{2,0},{1,-51},{2,1},{2,1},{2,-1},{1,39},
    	{1,59},{1,45},{2,0},{1,-70},{2,0},{1,23},{1,88},{1,83},{1,69},{1,-78},
    	{1,-3},{1,-9},{1,-20},{1,-74},{1,-62},{1,5},{1,55},{1,-36},{1,-21},{1,-94},
    	{1,-27},{1,-69},{2,0},{1,-30},{1,-84},{2,0},{2,0},{2,-1},{1,92},{1,60},{2,1},
    	{2,0},{1,-63},{2,0},{1,-87},{1,66},{2,0},{1,17},{2,0},{2,1},{1,-41},{1,-3},
    	{1,-29},{1,72},{2,1},{1,35},{1,81},{1,-83},{1,-17},{1,36},{1,99},{1,-17},{1,8},
    	{2,0},{1,80},{1,50},{1,80},{2,0},{1,-48},{1,-82},{1,-63},{1,2},{2,1},{1,-43},
    	{1,59},{1,93},{1,55},{1,-93},{2,-1},{1,2},{1,13},{2,0}};
    	

    	ArrayList<Integer> r = asylum(test2);
    	for (int i = 0; i < r.size(); i++) {
    		System.out.print(r.get(i) + " ");
    	}
    }
}