package string;

import java.util.Stack;

/**
 * 28��չ �ַ�������ϣ�ab��ba��һ����ϣ�
 * ��ͷɨ���һ�����ַ���n���ַ��е�m���ַ���ȫ����ϣ�
 * ���ڵ�һ���ַ�
 * ��1����һ���ַ�������У���ʣ�µ�n-1���ַ���ѡ��m-1�����
 * ��2����һ���ַ���������У���ʣ�µ�n-1���ַ���ѡ��m�����
 * @author HJH
 *
 */
public class StringCombine_28 {
	
	public static void StringCom(char[] chs){
		Stack<Character> stack = new Stack<>();
		for(int i=1;i<=chs.length;i++){
			Combine(chs, 0, i,stack);
		}
	}

	//���ַ������鳤��Ϊm�����
	public static void Combine(char[] chs,int begin,int m,Stack<Character> stack){
		if (m==0) {
			System.out.println(stack.toString());
			return;
		}
		if (begin == chs.length) {
			return;
		}
		stack.push(chs[begin]);	//��һ���ַ����������
		Combine(chs, begin+1, m-1,stack);	//��һ���ַ���������У���n-1���ַ���ѡȡm-1���ַ��������
		stack.pop();	//��һ���ַ������������
		//PrintChar(chs, begin, m);
		Combine(chs, begin+1, m,stack);	//��һ���ַ�����������У���n-1���ַ���ѡȡm���ַ�
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chs = {'a','b','c'};
		StringCom(chs);
	}

	public static void PrintChar(char[] chs,int start,int length){
		for (int i = start; i < start+length; i++) {
			System.out.print(chs[i]);
		}
		System.out.println();
	}
}
