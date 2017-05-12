package array;
/**
 * 31.连续子数组累加的最大值。。
 * 输入一个整型数组，数组中有正数有负数；数组中一个或连续多个整数数组组成一个子数组，求所有子数组的和的最大值，时间复杂度为O（n）
 * @author HJH
 *
 */
public class GreatestSumOfSubarrays_31 {

	public static int getMaxSumOfArray(int[] arr){
		if (arr.length <=0) {
			throw new RuntimeException();	//不合法的输入，抛出运行时异常
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
