package goodCode;
/**
 * 32、从1到n整数中1出现的次数
 * 输入一个整数n，求从1到n个整数中十进制表示中1出现的次数
 * 例如 12 从1到12十进制数中，1一共出现了5次
 * @author HJH
 *
 */
public class NumberOf1_32 {

	public static int numOf1(int num){
		if (num == 0) {	//跳出递归 递归的终止条件
			return 0;
		}
		int len = getLenOfNum(num);
		int tmp = (int)Math.pow(10, len-1);	//最高位的基数 比如 21345 --》 10000
		int first = num/tmp;	//得到第一个数字
		//分成两部分 例如 21345-----—— 1-》1345   1346-》21345 递归进行
		//先考虑1346-》21345
		int firstOneNum = first == 1 ?  num%tmp + 1 : tmp;	//计算第一个是1
		int otherOneNum = first * (len-1) * (tmp/10);	//其他位分别是1 出现的次数---最高位数字*除去最高位剩下的位数*某一位固定1，剩下的变化数
		
		return firstOneNum + otherOneNum + numOf1(num % tmp);	//递归实现
		
	}
	
	public static int getLenOfNum(int num){
		int len = 0 ;
		while(num !=0){
			len++;
			num = num/10;
		}
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numOf1(1));
		System.out.println(numOf1(5));
		System.out.println(numOf1(21345));
	}

}
