package stackQueue;

import java.util.Stack;

/**
 * 22��ջ��ѹ�룬�������� ���������������У���һ�����б�ʾջ��ѹ��˳���жϵڶ��������Ƿ�Ϊ��ջ�ĵ�������
 * 
 * @author HJH
 *
 */
public class StackPushPopOrder_22 {

	/**
	 * �ж�pop���еĵ�ջ˳���Ƿ�Ϊ��ջ
	 * 
	 * @param push
	 * @param pop
	 * @return
	 */
	public static boolean IsPopOrder(int[] push, int[] pop) {
		boolean flag = false;
		int index = 0; // ��¼ѹջ������±꣬��������
		int i = 0;	//��¼����������±�
		Stack<Integer> dataStack = new Stack<>(); // ѹջ
		while(i<pop.length) { // ��˳�򿼲�pop����
			if (dataStack.empty()) {	//����ջΪ��ʱ��ѹ������
				dataStack.push(push[index]);
				index++;
			}
			if (pop[i] == dataStack.peek()) {
				dataStack.pop();
				i++;	//����������������
				continue;
			}else {
				//��ѹջ�����л�û����ջ������ѹ��ջ�У�ֱ������һ����Ҫ����������ѹ��ջ��Ϊֹ
				while(index<push.length && push[index] != pop[i] ){
					dataStack.push(push[index]);
					index++;
				}
				if (index >= push.length) {	//�������е�Ԫ�ض��Ѿ�ѹ��ջ
					break;
				}
				if (push[index] == pop[i]) {
					dataStack.push(push[index++]);
				}
			}
		}
		if (dataStack.empty()) {
			flag = true;
		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] push = {1,2,3,4,5};
		int[] pop = {4,5,3,2,1};
		System.out.println(IsPopOrder(push, pop));
	}

}
