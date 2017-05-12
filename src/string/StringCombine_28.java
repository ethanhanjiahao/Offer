package string;

import java.util.Stack;

/**
 * 28扩展 字符串的组合（ab、ba算一个组合）
 * 从头扫描第一个个字符（n个字符中的m个字符的全部组合）
 * 对于第一个字符
 * （1）第一个字符在组合中，从剩下的n-1个字符中选择m-1个组合
 * （2）第一个字符不在组合中，从剩下的n-1个字符中选择m个组合
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

	//求字符串数组长度为m的组合
	public static void Combine(char[] chs,int begin,int m,Stack<Character> stack){
		if (m==0) {
			System.out.println(stack.toString());
			return;
		}
		if (begin == chs.length) {
			return;
		}
		stack.push(chs[begin]);	//第一个字符放入组合中
		Combine(chs, begin+1, m-1,stack);	//第一个字符放入组合中，从n-1个字符中选取m-1个字符进行组合
		stack.pop();	//第一个字符不放在组合中
		//PrintChar(chs, begin, m);
		Combine(chs, begin+1, m,stack);	//第一个字符不放入组合中，从n-1个字符中选取m个字符
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
