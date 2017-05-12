package stackQueue;

import java.util.Stack;

import javax.management.RuntimeErrorException;

/**
 * 7.
 * ������ջʵ�ֶ���
 * @author HJH
 *
 */
public class TwoStackQueue_7 {

	public Stack<Integer> stackPush;	//��Ϊѹ�����
	public Stack<Integer> stackPop;		//��Ϊ��������
		
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
				stackPop.add(stackPush.pop());	//��ѹ���������Ԫ���������������
			}
		}
		return stackPop.pop();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
