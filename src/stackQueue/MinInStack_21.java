package stackQueue;

import java.util.Stack;

/**
 * 定义栈的数据结构，能够实现min函数。在栈中，调用min,push,pop的时间复杂度都为O(1)
 * @author HJH
 *
 */
public class MinInStack_21 {

	public static class GetMinStack{
		Stack<Integer> dataStack = new Stack<Integer>();
		Stack<Integer> minStack = new Stack<Integer>();
		
		//压入栈，需要考虑是否压入min栈
		public void push(int data){
			//如果data>最小栈的栈顶（最小值），则持续压入栈顶（最小值）
			if (minStack.empty()) {
				minStack.push(data);
			}else if (data < minStack.peek()) {
				minStack.push(data);
			}else {
				minStack.push(minStack.peek());
			}
			dataStack.push(data);
		}
		
		//弹栈操作
		public int pop(){
			if (dataStack.empty()) {
				throw new RuntimeException();	//抛出运行时异常
			}else {
				minStack.pop();
				return dataStack.pop();
			}
		}
		
		//得到最小值
		public int min(){
			if (minStack.empty()) {
				throw new RuntimeException();	//抛出运行时异常
			}
			return minStack.peek();	//栈顶元素为最小值
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMinStack stack1 = new GetMinStack();
		stack1.push(3);
		System.out.println(stack1.min());
		stack1.push(4);
		System.out.println(stack1.min());
		stack1.push(1);
		System.out.println(stack1.min());
		System.out.println(stack1.pop());
		System.out.println(stack1.min());
	}

}
