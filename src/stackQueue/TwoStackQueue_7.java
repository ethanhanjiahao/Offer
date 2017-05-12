package stackQueue;

import java.util.Stack;

import javax.management.RuntimeErrorException;

/**
 * 7.
 * 用两个栈实现队列
 * @author HJH
 *
 */
public class TwoStackQueue_7 {

	public Stack<Integer> stackPush;	//作为压入队列
	public Stack<Integer> stackPop;		//作为弹出队列
		
	public TwoStackQueue_7(Stack<Integer> stackPush, Stack<Integer> stackPop) {
		super();
		this.stackPush = stackPush;
		this.stackPop = stackPop;
	}
	
	public void add(int pushInt){
		stackPush.add(pushInt);
	}
	
	public int poll(){
		if (stackPush.isEmpty() && stackPop.isEmpty()) {
			throw new RuntimeErrorException(null, "Queue is empty");
		}else if (stackPop.empty()) {
			while(!stackPush.empty()){
				stackPop.add(stackPush.pop());	//将压入队列所有元素添加至弹出队列
			}
		}
		return stackPop.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
