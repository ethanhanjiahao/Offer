package array;

/**
 * 29.���������ҳ���������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬�ҳ��������
 * @author HJH
 *
 */
public class MoreThanHalfNum_29 {

	/**
	 * ����һ
	 * ����Partition������O��n���㷨
	 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�롣����������ź���ģ���ô�����λ�������м������һ���ǳ������鳤��һ�������
	 * �����O��n���㷨�õ������������K�������
	 * �ܵ����ŵ������������ѡȡһ�����֣��������������ֵ�˳��ʹ�ñ�ѡ�е�����С�����ֶ�����������ߣ���ѡ�����ִ�����ֶ����������ұ�
	 */
	public static int MoreThanHalf(int[] array){
		if (array==null) {
			throw new RuntimeException();
		}
		int middle = array.length >>1;
		int start = 0;
		int end = array.length-1;
		int index = Partition(array, start, end);
		while(index != middle){
			if (index > middle) {
				index = Partition(array, start, index-1);
			}
			else {
				index = Partition(array, index+1, end);
			}
		}
		int result = array[middle];
		//�걸�Լ��
		if (!checkMoreThanHalf(array, result)) {
			result = 0;
		}
		return result;
	}
	
	//�ؼ�����partition����������������˳��ʹ����ߵ����ֶ�����ѡ������С���ұߵ����ֶ�����ѡ�����ִ�
	public static int Partition(int[] array,int start,int end){
		int index = start + (int)(Math.random() * (end-start +1));	//���ѡȡһ�������±�
		int position = array[index];
		swap(array, start, index);	//����
		while(start < end){	//�Ե�һ��������Ϊposition��partition����
			while (start < end && array[end]>position) end--;
			if (start < end) {
				array[start++] = array[end];	//�����滻�������ý������У���Լ������Դ
			}
			while(start < end && array[start] <= position) start++;
			if (start<end) {
				array[end--] = array[start];	//�����滻�������ý������У���Լ��Դ
			}
		}
		array[start] = position;
		return start;
	}
	
	//���齻��
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	//�걸�Լ�� ����ǲ�����ѡ���ֳ����������һ�볤��
	public static boolean checkMoreThanHalf(int[] array,int number){
		int times = 0;
		for(int i=0;i<array.length;i++){
			if (array[i] == number) {
				times++;
			}
		}
		if (times*2 <= array.length) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,2,2,2,5,4,2};
		System.out.println(MoreThanHalf(array));
	}
	
	
	//����������������ص㣬�ҳ�O��n�����㷨
	/**
	 * ������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬Ҳ����˵�����ֵĴ����������������ֳ��ֵĴ����ĺͻ�Ҫ��
	 * ��ˣ����Ա�������ֵ���������ֺʹ���
	 * �����һ�����ֺ�֮ǰ�����������ͬ���������һ
	 * �����һ�����ֺ�֮ǰ��������ֲ�ͬ��������һ
	 * �������Ϊ0������Ҫ������һ�����֣����Ҵ�����Ϊ1
	 * ���Ҫ�����һ�ΰѴ�������Ϊ1��Ӧ������
	 */
	public static int MoreThanHalf2(int[] array){
		if (array==null) {
			throw new RuntimeException();
		}
		int result = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			if (times == 0) {
				result = array[i];
				times =1;
			}else if (array[i] == result) {
				times ++;
			}else {
				times --;
			}
		}
		if (!checkMoreThanHalf(array, result)) {
			result = 0;
		}
		return result;
	}
}
