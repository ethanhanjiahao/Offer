package string;
/**
 * 输入一个字符串，打印出该字符串中所有字符的全排列
 * 如果需要按照字典的顺序进行输出的话，将结果转换为String，用TreeSet进行包装 进行单独输出即可
 * @author HJH
 *
 */
public class StringPermutation_28 {

	public static void permutation(char[] str) {
		if (str == null) {
			return;
		}

		permutation(str, 0);
	}

	//首先求所有可能出现在第一个位置的字符，即把第一个字符和后面所有字符进行交换
	//第二步，固定第一个字符，求后面所有字符的全排列
	private static void permutation(char[] str, int begin) {
		if (begin == str.length) {
			System.out.println(String.valueOf(str));
		}
		else {
			for (int i = begin; i < str.length; i++) {
				char temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;	//将第一个字符与后面的字符逐一交换

				permutation(str, begin + 1);	//对后面所有的字符进行全排列（固定第一个字符，求后面字符的全排列）

				temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;		//将交换后的字符交换回来，以便和其他后面的字符进行交换

			}
		}
	}

	public static void main(String[] args) {

		char[] str = { 'a', 'b', 'c' };
		permutation(str);
	}
}
