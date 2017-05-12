package array;
/**
 * 要求空间复杂度为O（1） 合并数组子有序段
 * a[0...mid-1]和a[mid...n-1]分别有序
 * @author HJH
 *
 */
public class MergeTwoArray {

	//调整a[mid...n-1]为有序数组
	public static void findRightPlaceMid(int[] a,int mid){
		int tmp = a[mid];
		int i=mid+1;
		for(;i<a.length-1 && a[i]<tmp;i++){
			a[i-1] = a[i];
		}
		a[i-1] = tmp;
	}
	
	//合并数组子有序段
	public static void merge(int[] a,int mid){
		for (int i = 0; i < mid; i++) {
			if (a[mid] < a[i]) {	//交换mid和i之间的数值
				swap(a, i, mid);
				findRightPlaceMid(a, mid);	//调整a[mid...n-1]为有序
			}
		}
	}
	
	public static void swap(int[] a ,int index1,int index2){
		int tmp = a[index1];
		a[index1] = a[index2];
		a[index2] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a ={1,5,6,7,8,2,4,8,10,13,14};
		merge(a, 5);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}

}
