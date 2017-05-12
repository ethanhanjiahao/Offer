package bitCalculate;
/**
 * 10.二进制数中有多少个1
 * 如果把一个整数减去1，再和原整数相与，会把该整数最右边一个1变为0；如果相与结果为0，则原整数中不存在1
 * 
 * 较为慢的方法：原整数与1相与，判断最后一位是否为1 
 * 			  原整数与1<<1(1左移一位，变为2)，判断倒数第二位是否为1
 * 			  依次类推
 * @author HJH
 *
 */
public class HowMany1 {

	public static int getHowManyOne(int n){
		int count = 0;
		while(n!=0){
			n = (n-1)&n;
			count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getHowManyOne(0xFFFFFFFF));
	}

}
