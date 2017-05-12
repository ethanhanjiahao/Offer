package stackQueue;

import java.util.Stack;

/**
 * 22、栈的压入，弹出序列 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出序列
 * 
 * @author HJH
 *
 */
public class StackPushPopOrder_22 {

	/**
	 * 判断pop序列的弹栈顺序是否为本栈
	 * 
	 * @param push
	 * @param pop
	 * @return
	 */
	public static boolean IsPopOrder(int[] push, int[] pop) {
		boolean flag = false;
		int index = 0; // 记录压栈数组的下标，持续增加
		int i = 0;	//记录弹出数组的下标
		Stack<Integer> dataStack = new Stack<>(); // 压栈
		while(i<pop.length) { // 按顺序考查pop数组
			if (dataStack.empty()) {	//辅助栈为空时，压入数据
				dataStack.push(push[index]);
				index++;
			}
			if (pop[i] == dataStack.peek()) {
				dataStack.pop();
				i++;	//继续遍历弹出数组
				continue;
			}else {
				//把压栈序列中还没有入栈的数字压入栈中，直到把下一个需要弹出的数字压入栈顶为止
				while(index<push.length && push[index] != pop[i] ){
					dataStack.push(push[index]);
					index++;
				}
				if (index >= push.length) {	//当把所有的元素都已经压入栈
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
