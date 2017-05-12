package goodCode;
/**
 * ������ֻ��������2,3,5������
 * ����С�����˳�������1500������
 * @author HanJiahao
 *
 */
public class UglyNumber_34 {

	//����һ ���ճ����Ķ��壬��һ�ж�ÿ�������ǲ��ǳ���
	//������ �ÿռ任ȡʱ�䣬�������鱣���Ѿ��ҵ��ĳ���
	/**
	 * ÿһ����������ǰ��ĳ�������2��3��5�õ�����
	 * ���Ѿ�����ĳ��������У��ҵ�һ����M2��С��M2����*2С�ڵ�ǰ�����������ֵ
	 * ͬ�� �ҵ�M3��M5
	 * ��һ��������Ϊmin(M2*2,M3*3,M5*5)���������鼴��
	 * @param args
	 */
	public static int getUgly(int num){
		int[] ugly = new int[num];
		ugly[0] = 1;
		//int indexUgly = 1;
		int minM2 = 0;
		int minM3 = 0;
		int minM5 = 0;
		int index = 1;
		while(index < num){
			ugly[index] = getMin(ugly[minM2]*2, ugly[minM3]*3, ugly[minM5]*5);
			//����minm2
			while(ugly[minM2]*2 <= ugly[index]) minM2 ++;
			//����minM3
			while(ugly[minM3]*3 <= ugly[index]) minM3 ++;
			//����minM5
			while(ugly[minM5]*5 <= ugly[index]) minM5 ++;
			index++;
		}
		return ugly[num-1];
	}
	
	public static int getMin(int a,int b,int c) {
		return (a<b) ? ((a<c) ? a : c) : ((b<c) ?b : c);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getUgly(1500));
	}

}
