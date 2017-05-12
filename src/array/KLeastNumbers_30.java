package array;

import java.util.Arrays;

/**
 * 30.最小的K个数；输入n个整数，找出其中最小的k个数
 * @author HJH
 *
 */
public class KLeastNumbers_30 {
	
	//O(nlogK)的算法，适合海量数据的处理
	//创建一个k空间的辅助空间，每次从arr中读取一个数，直到k个数为止
	//接下来，一个一个遍历之后的数字，只能一个一个替换，不能再进行插入；当前遍历的元素小于最大值，不替换，大于最大值，替换
	public static void getLeastsNumbers(int[] arr,int k){
		if (k > arr.length) {
			return;
		}
		int[] tmp = new int[k];
		tmp = Arrays.copyOf(arr, k);
		createMaxHeap(tmp);
		for(int i=k-1;i<arr.length;i++){
			if (arr[i] < tmp[0]) {
				tmp[0] = arr[i];
				createMaxHeap(tmp);
			}
		}
		for (int i : tmp) {
			System.out.print(i+" ");
		}
	}

	//采用堆排序，生成大顶堆
	public static void createMaxHeap(int[] arr){
		int lastIndex = arr.length -1;
		for(int i=(lastIndex-1)/2;i>=0;i--){	//循环生成大顶堆
			int k = i;
			while(2*k+1 <= lastIndex){
				int left = 2*k+1;
				int right = 2*k+2;
				int biggest = k;
				if (left <=lastIndex && arr[biggest] < arr[left]) {
					biggest = left;
				}
				if (right <= lastIndex && arr[biggest] < arr[right]) {
					biggest = right;
				}
				if (biggest != k) {
					swap(arr, k, biggest);
					k = biggest;
				}else {
					break;
				}
			}
		}
	}
	
	public static void swap(int[] chas, int index1, int index2) {
		int tmp = chas[index1];
		chas[index1] = chas[index2];
		chas[index2] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,5,1,6,2,7,3,8};
		getLeastsNumbers(a, 4);
	}

}
