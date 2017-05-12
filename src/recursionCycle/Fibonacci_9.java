package recursionCycle;
/**
 *9.递归和循环实现斐波那契数列
 * f(0) = 0
 * f(1) = 1
 * f(n) = f(n-1)+f(n-2)
 * @author HJH
 *递归包含很多重复的计算，循环可以更加实用，将中间结果保存起来
 */
public class Fibonacci_9 {

	//递归实现
	public static long recurFab(int n){
		if (n<=0) {	//递归的终止条件
			return 0;
		}
		if (n==1) {
			return 1;
		}
		return recurFab(n-1) + recurFab(n-2);
	}
	
	//循环实现斐波那契数列
	public static long cycleFab(int n){
		long fabOne = 1;
		long fabTwo = 0;
		if (n<=0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		long fabN = 0;
		for(int i=2;i<=n;i++){
			fabN = fabOne + fabTwo;
			fabTwo = fabOne;
			fabOne = fabN;
		}
		return fabN;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(recurFab(10));
		System.out.println(cycleFab(10));
	}

}
