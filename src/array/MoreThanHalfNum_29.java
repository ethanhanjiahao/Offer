package array;

/**
 * 29.在数组中找出数组中有一个数字出现的次数超过数组长度的一半，找出这个数字
 * @author HJH
 *
 */
public class MoreThanHalfNum_29 {

	/**
	 * 方法一
	 * 基于Partition函数的O（n）算法
	 * 数组中有一个数字出现的次数超过数组长度的一半。如果数组是排好序的，那么排序后位于数组中间的数字一定是超过数组长度一半的数字
	 * 成熟的O（n）算法得到数组中任意第K大的数字
	 * 受到快排的启发。先随机选取一个数字，调整数组中数字的顺序，使得比选中的数字小的数字都排在它的左边，比选中数字大的数字都排在它的右边
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
		//完备性检查
		if (!checkMoreThanHalf(array, result)) {
			result = 0;
		}
		return result;
	}
	
	//关键在与partition；调整数组中数字顺序，使得左边的数字都比所选的数字小，右边的数字都比所选的数字大
	public static int Partition(int[] array,int start,int end){
		int index = start + (int)(Math.random() * (end-start +1));	//随机选取一个数的下标
		int position = array[index];
		swap(array, start, index);	//交换
		while(start < end){	//以第一个数字作为position的partition方法
			while (start < end && array[end]>position) end--;
			if (start < end) {
				array[start++] = array[end];	//采用替换而不采用交换进行，节约交换资源
			}
			while(start < end && array[start] <= position) start++;
			if (start<end) {
				array[end--] = array[start];	//采用替换而不采用交换进行，节约资源
			}
		}
		array[start] = position;
		return start;
	}
	
	//数组交换
	public static void swap(int[] arr,int i,int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
	
	//完备性检查 检查是不是所选数字超过了数组的一半长度
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
	
	
	//法二：根据数组的特点，找出O（n）的算法
	/**
	 * 数组中一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现的次数的和还要多
	 * 因此，可以保存两个值：保存数字和次数
	 * 如果下一个数字和之前保存的数字相同，则次数加一
	 * 如果下一个数字和之前保存的数字不同，次数减一
	 * 如果次数为0，则需要保存下一个数字，并且次数设为1
	 * 最后要找最后一次把次数设置为1对应的数字
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
