package bitCalculate;
/**
 * 40.数组中只出现一次的数字
 * 一个整型数组中除了两个数字出现一次以外以外，其他数字都出现两次，找出这两个数字
 * @author HanJiahao
 *题眼：一个数组中只有一个数字出现一次，其他数字都出现两次，求这个出现一次的数字
 *任何一个数字异或自己均为0，从头到尾异或数组中的每一个数字，最终得到的便是出现一次的数字
 */

public class NumberAppearOnce_40 {

	/**
	 * 数组中只有一个数字出现一次，其他都出现两次，找到出现一次的数字
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
	 * num中从右至左第一个出现的1的位置
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
		int inedx = indexOfOne(NumberOnce(arr)); 	//获取异或结果第一个1出现的位置
		//以第index位是否为1 将原数组分成两个子数组，这样 每个子数组中存在唯一一个出现一次的数，其他均出现两次
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
