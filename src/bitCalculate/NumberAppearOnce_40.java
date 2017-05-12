package bitCalculate;
/**
 * 40.������ֻ����һ�ε�����
 * һ�����������г����������ֳ���һ���������⣬�������ֶ��������Σ��ҳ�����������
 * @author HanJiahao
 *���ۣ�һ��������ֻ��һ�����ֳ���һ�Σ��������ֶ��������Σ����������һ�ε�����
 *�κ�һ����������Լ���Ϊ0����ͷ��β��������е�ÿһ�����֣����յõ��ı��ǳ���һ�ε�����
 */

public class NumberAppearOnce_40 {

	/**
	 * ������ֻ��һ�����ֳ���һ�Σ��������������Σ��ҵ�����һ�ε�����
	 * @param arr
	 * @return
	 */
	public static int NumberOnce(int[] arr){
		int length = arr.length;
		int res = 0;
		for(int i=0;i<length;i++){
			res ^= arr[i];
		}
		return res;
	}
	
	/**
	 * num�д��������һ�����ֵ�1��λ��
	 * @param num
	 * @return
	 */
	public static int indexOfOne(int num){
		int index = 0;
		while((num!= 0 ) && (num&1) == 0){
			num = num >> 1;
			index++;
		}
		return index;
	}
	
	public static int[] getNumber(int[] arr){
		int[] tmp = new int[2];
		int inedx = indexOfOne(NumberOnce(arr)); 	//��ȡ�������һ��1���ֵ�λ��
		//�Ե�indexλ�Ƿ�Ϊ1 ��ԭ����ֳ����������飬���� ÿ���������д���Ψһһ������һ�ε�������������������
		for(int i=0;i<arr.length;i++){
			if (((arr[i] >> inedx) & 1) == 1) {
				tmp[0] ^= arr[i];
			}else {
				tmp[1] ^= arr[i];
			}
		}
		return tmp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1,1,2,2,4,4,6,3,3,5,5,8};
		int[] result = getNumber(arr);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
