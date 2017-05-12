package array;
/**
 * 20.˳ʱ���ӡ����
 * @author HJH
 *
 */
public class PrintMatrix_20 {

	/**
	 * �����������ѭ������ӡ����
	 * @param array ��ά����
	 * @param rows	��ά�������
	 * @param columns ��ά�������
	 */
	public static void matrixPrint(int[][] array,int rows,int columns){
		//�걸�Լ�飬����Ľ�׳��(³����)
		if (array == null || rows==0 || columns == 0) {
			return ;
		}
		int start = 0;
		//ѭ������ֹ����
		while(columns > start*2 && rows > start*2){
			printOneCircle(array,rows,columns,start);	//��ӡһȦ������
			start++;
		}
	}
	
	/**
	 * ��ӡһȦ������ ��������->�Ҵ�ӡһ��
	 * ����->�´�ӡһ��
	 * ����->���ӡһ��
	 * ����->�ϴ�ӡһ��
	 */
	public static void printOneCircle(int[][] array,int rows,int columns,int start){
		int endX = rows - start -1;
		int endY = columns - start -1;
		
		//�������Ҵ�ӡһ��
		for(int i=start;i<=endY;i++){
			System.out.print(array[start][i]+"��");
		}
		//�������´�ӡһ��
		if (endX - start >0) {//��ֹ�кŴ��ڿ�ʼ�к�
			for(int i=start+1;i<=endX;i++){
				System.out.print(array[i][endY]+"��");
			}
		}
		//���������ӡһ��
		if (endX > start && endY > start) {	//��ֹ�кŴ��ڿ�ʼ�кţ���ֹ�кŴ��ڿ�ʼ�к�
			for(int i = endY-1;i>=start;i--){
				System.out.print(array[endX][i]+"��");
			}
		}
		//�������ϴ�ӡһ��
		if (endY > start && endX - start > 1) {	//��ֹ�кŴ��ڿ�ʼ�к� ���� ��ֹ�кűȿ�ʼ�к����ٶ�2
			for(int i = endX - 1;i> start;i--){
				System.out.print(array[i][start]+"��");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		matrixPrint(array, 3, 4);
	}

}
