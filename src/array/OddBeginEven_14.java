package array;
/**
 * 14 ���������˳��ʹ����������Ԫ����ż��Ԫ��ǰ��
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ����������λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿��
 * @author HJH
 *
 */
public class OddBeginEven_14 {

	public static void order(int[] array){
		if (array.length == 0) {
			return ;
		}
		int start = 0,end = array.length-1;
		//ż�����������н�������ż������������
		while(start < end){
			//����ƶ���ֱ������ż��
			while(start<end && (array[start] & 0x01)!=0){
				start++;
			}
			//��ǰ�ƶ���ֱ��������
			while(start < end && (array[end] & 0x01) == 0){
				end--;
			}
			//������ż��
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
