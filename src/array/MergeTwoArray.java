package array;
/**
 * Ҫ��ռ临�Ӷ�ΪO��1�� �ϲ������������
 * a[0...mid-1]��a[mid...n-1]�ֱ�����
 * @author HJH
 *
 */
public class MergeTwoArray {

	//����a[mid...n-1]Ϊ��������
	public static void findRightPlaceMid(int[] a,int mid){
		int tmp = a[mid];
		int i=mid+1;
		for(;i<a.length-1 && a[i]<tmp;i++){
			a[i-1] = a[i];
		}
		a[i-1] = tmp;
	}
	
	//�ϲ������������
	public static void merge(int[] a,int mid){
		for (int i = 0; i < mid; i++) {
			if (a[mid] < a[i]) {	//����mid��i֮�����ֵ
				swap(a, i, mid);
				findRightPlaceMid(a, mid);	//����a[mid...n-1]Ϊ����
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
