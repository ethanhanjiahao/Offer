package string;
/**
 * 将String转换成int值。。。注意异常值和越界等相关问题的考虑
 * @author HJH
 *
 */
public class StringToInt_49 {

	
	/**
	 * 异常情况
	 * 开头出现空格
	 * 第一个字符为正负号，出现非数字
	 * 越界
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {
		int result = 0;
		str = str.trim();	//去除开头的空格
		char[] charStr = str.toCharArray();
		boolean position = true;
		for(int i=0;i<charStr.length;i++){
			char c = charStr[i];
			if (i==0 && (c=='-' || c=='+')) {
				position = c=='-' ? false : true;
			}else if (c>='0' && c<='9') {	//为数字
				//判断是否越界
				if (result > ((Integer.MAX_VALUE - c - '0') / 10)) {
					return position ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				result = result*10 + c-'0';
			}else {	//遇到第一个非数字 直接返回
				return position ? result : -result;
			}
		}
	    return position ? result : -result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
