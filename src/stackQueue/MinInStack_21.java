package stackQueue;

import java.util.Stack;

/**
 * ����ջ�����ݽṹ���ܹ�ʵ��min��������ջ�У�����min,push,pop��ʱ�临�Ӷȶ�ΪO(1)
 * @author HJH
 *
 */
public class MinInStack_21 {

	public static class GetMinStack{
		Stack<Integer> dataStack = new Stack<Integer>();
		Stack<Integer> minStack = new Stack<Integer>();
		
		//ѹ��ջ����Ҫ�����Ƿ�ѹ��minջ
		public void push(int data){
			//���data>��Сջ��ջ������Сֵ���������ѹ��ջ������Сֵ��
			if (minStack.empty()) {
				minStack.push(data);
			}else if (data < minStack.peek()) {
				minStack.push(data);
			}else {
				minStack.push(minStack.peek());
			}
			dataStack.push(data);
		}
		
		//��ջ����
		public int pop(){
			if (dataStack.empty()) {
				throw new RuntimeException();	//�׳�����ʱ�쳣
			}else {
				minStack.pop();
				return dataStack.pop();
			}
		}
		
		//�õ���Сֵ
		public int min(){
			if (minStack.empty()) {
				throw new RuntimeException();	//�׳�����ʱ�쳣
			}
			return minStack.peek();	//ջ��Ԫ��Ϊ��Сֵ
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
