package array;
/**
 * 14 调整数组的顺序，使得所有奇数元素在偶数元素前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 * @author HJH
 *
 */
public class OddBeginEven_14 {

	public static void order(int[] array){
		if (array.length == 0) {
			return ;
		}
		int start = 0,end = array.length-1;
		//偶数和奇数进行交换，将偶数交换至后面
		while(start < end){
			//向后移动，直至遇到偶数
			while(start<end && (array[start] & 0x01)!=0){
				start++;
			}
			//向前移动，直至遇到奇
			while(start < end && (array[end] & 0x01) == 0){
				end--;
			}
			//交换奇偶数
			if (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5};
		order(array);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}

}
