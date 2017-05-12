package recursionCycle;
/**
 *9.�ݹ��ѭ��ʵ��쳲���������
 * f(0) = 0
 * f(1) = 1
 * f(n) = f(n-1)+f(n-2)
 * @author HJH
 *�ݹ�����ܶ��ظ��ļ��㣬ѭ�����Ը���ʵ�ã����м�����������
 */
public class Fibonacci_9 {

	//�ݹ�ʵ��
	public static long recurFab(int n){
		if (n<=0) {	//�ݹ����ֹ����
			return 0;
		}
		if (n==1) {
			return 1;
		}
		return recurFab(n-1) + recurFab(n-2);
	}
	
	//ѭ��ʵ��쳲���������
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
