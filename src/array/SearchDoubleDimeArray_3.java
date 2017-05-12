package array;
/**3.
 * 二维数组中，每一行都按照从左至右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 输入一个二维数组和一个数字，判断数组中是否有该整数
 * @author HJH
 *
 */
public class SearchDoubleDimeArray_3 {

	//选择二维数组右上角或者左下角进行比较，能够剔除一行或者一列
	public static boolean findInteger(int[][] arr,int x) {
		boolean flag = false;
		int m = arr.length;
		int n = arr[0].length;
		int i = 0;	//控制行的移动
		int j = n-1;	//控制列的移动
		while(i<m && j>=0){
			if (x==arr[i][j]) {
				flag = true;
				break;
			}else if (x<arr[i][j]) {
				j--;	//剔除一列
			}else {
				i++;	//剔除一行
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
