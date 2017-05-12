package bitCalculate;
/**
 * 10.�����������ж��ٸ�1
 * �����һ��������ȥ1���ٺ�ԭ�������룬��Ѹ��������ұ�һ��1��Ϊ0�����������Ϊ0����ԭ�����в�����1
 * 
 * ��Ϊ���ķ�����ԭ������1���룬�ж����һλ�Ƿ�Ϊ1 
 * 			  ԭ������1<<1(1����һλ����Ϊ2)���жϵ����ڶ�λ�Ƿ�Ϊ1
 * 			  ��������
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
