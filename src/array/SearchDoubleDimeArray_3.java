package array;
/**3.
 * ��ά�����У�ÿһ�ж����մ������ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
 * ����һ����ά�����һ�����֣��ж��������Ƿ��и�����
 * @author HJH
 *
 */
public class SearchDoubleDimeArray_3 {

	//ѡ���ά�������Ͻǻ������½ǽ��бȽϣ��ܹ��޳�һ�л���һ��
	public static boolean findInteger(int[][] arr,int x) {
		boolean flag = false;
		int m = arr.length;
		int n = arr[0].length;
		int i = 0;	//�����е��ƶ�
		int j = n-1;	//�����е��ƶ�
		while(i<m && j>=0){
			if (x==arr[i][j]) {
				flag = true;
				break;
			}else if (x<arr[i][j]) {
				j--;	//�޳�һ��
			}else {
				i++;	//�޳�һ��
			}
		}
		return flag;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(findInteger(test,88));
	}

}
