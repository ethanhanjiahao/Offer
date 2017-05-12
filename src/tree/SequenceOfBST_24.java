package tree;
/**
 * 24.�����������ĺ����������
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ����������...������������������������ֻ�����ͬ
 * @author HJH
 *
 */
public class SequenceOfBST_24 {

	/**
	 * ������������У����һ�����������ĸ��ڵ��ֵ��
	 * ��һ���ֶ��ȸ����С��������������ֵ
	 * �ڶ����ֶ��ȸ��ڵ��������������ֵ
	 * ֮��ݹ��ж����������ݹ��ж�������
	 */
	public static boolean VerifySequenceOfBST(int[] array,int start,int length){
		if (array==null || length<=0) {
			return false;
		}
		int root = array[length-1];	//���ڵ�
		int i = 0;
		//�ҵ����������
		while(i<length-1 && array[i]<root){
			if (array[i]<root) {i++;}
		}
		int j = i;	//������������㣨�����������Ҫȫ�����ڸ��ڵ㣩
		while(j<length-1){
			if (array[j]<root) {	//�������������С�ڸ���㣬����false
				return false;
			}
			j++;
		}
		
		//�ݹ����������
		boolean left = true;
		if (i>0) {	//����������
			left = VerifySequenceOfBST(array, 0, i);
		}
		boolean right = true;
		//ѭ������������
		if (i<length-1) {	//����������
			right = VerifySequenceOfBST(array, i, length-i-1);
		}
		return left&&right;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {4};
		System.out.println(VerifySequenceOfBST(array, 0, array.length));
	}

}
