package array;
/**
 * 8.��ת�����е���Сֵ�����ֲ��ң�
 * @author HJH
 *
 */
public class MinRoateArray_8 {

	//������ת�����е���Сֵ
	public static int getMin(int[] array,int lenght){
		if(lenght==0){
			try {
				throw new Exception("No Numbers");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int index1 = 0;
		int index2 = lenght-1;
		int indexMid = 0;
		//��֤����ת����
		while(array[index1] >= array[index2]){
			//�������index2��index1��1ʱ������ѭ����index2Ϊ��Сֵ���±�
			if (index2 - index1 ==1) {
				indexMid = index2;
				break;
			}
			
			indexMid = (index2+index1)/2;
			//˳�����	[1,1,0,1,1,1,1] [1,1,1,1,0,1,1];��ȷ����Сֵ����߻������ұ�
			if (array[index1] == array[index2]) {
				return MinOrderArray(array,index1,index2);
			}else if (array[indexMid] >= array[index1]) {	//���ֲ��ҵ�˼��
				index1 = indexMid;
			}else if (array[indexMid] <= array[index2]) {
				index2 = indexMid;
			}
		}
		return array[indexMid];
	}
	
	//˳����������е���Сֵ
	public static int MinOrderArray(int[] array,int index1,int index2){
		int result = array[index1];
		for(int i=index1;i<=index2;i++){
			result = Math.min(result, array[i]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
