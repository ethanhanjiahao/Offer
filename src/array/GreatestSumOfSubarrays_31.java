package array;
/**
 * 31.�����������ۼӵ����ֵ����
 * ����һ���������飬�������������и�����������һ����������������������һ�������飬������������ĺ͵����ֵ��ʱ�临�Ӷ�ΪO��n��
 * @author HJH
 *
 */
public class GreatestSumOfSubarrays_31 {

	public static int getMaxSumOfArray(int[] arr){
		if (arr.length <=0) {
			throw new RuntimeException();	//���Ϸ������룬�׳�����ʱ�쳣
		}
		int res = 0;
		int max = 0;
		for(int i=0;i<arr.length;i++){
			if (res <=0) {
				res = arr[i];
			}else {
				res+=arr[i];
			}
			if (res > max) {
				max = res;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,-2,3,10,-4,7,2,-5};
		System.out.println(getMaxSumOfArray(arr));
	}

}
