package array;

import java.util.Arrays;

/**
 * 30.��С��K����������n���������ҳ�������С��k����
 * @author HJH
 *
 */
public class KLeastNumbers_30 {
	
	//O(nlogK)���㷨���ʺϺ������ݵĴ���
	//����һ��k�ռ�ĸ����ռ䣬ÿ�δ�arr�ж�ȡһ������ֱ��k����Ϊֹ
	//��������һ��һ������֮������֣�ֻ��һ��һ���滻�������ٽ��в��룻��ǰ������Ԫ��С�����ֵ�����滻���������ֵ���滻
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

	//���ö��������ɴ󶥶�
	public static void createMaxHeap(int[] arr){
		int lastIndex = arr.length -1;
		for(int i=(lastIndex-1)/2;i>=0;i--){	//ѭ�����ɴ󶥶�
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
