package array;
/**
 * 20.顺时针打印矩阵
 * @author HJH
 *
 */
public class PrintMatrix_20 {

	/**
	 * 从外向里进行循环，打印数字
	 * @param array 二维矩阵
	 * @param rows	二维矩阵的行
	 * @param columns 二维矩阵的列
	 */
	public static void matrixPrint(int[][] array,int rows,int columns){
		//完备性检查，程序的健壮性(鲁棒性)
		if (array == null || rows==0 || columns == 0) {
			return ;
		}
		int start = 0;
		//循环的终止条件
		while(columns > start*2 && rows > start*2){
			printOneCircle(array,rows,columns,start);	//打印一圈的数字
			start++;
		}
	}
	
	/**
	 * 打印一圈的数字 包括从左->右打印一行
	 * 从上->下打印一列
	 * 从右->左打印一行
	 * 从下->上打印一列
	 */
	public static void printOneCircle(int[][] array,int rows,int columns,int start){
		int endX = rows - start -1;
		int endY = columns - start -1;
		
		//从左至右打印一行
		for(int i=start;i<=endY;i++){
			System.out.print(array[start][i]+"、");
		}
		//从上至下打印一列
		if (endX - start >0) {//终止行号大于开始行号
			for(int i=start+1;i<=endX;i++){
				System.out.print(array[i][endY]+"、");
			}
		}
		//从右至左打印一行
		if (endX > start && endY > start) {	//终止行号大于开始行号，终止列号大于开始列号
			for(int i = endY-1;i>=start;i--){
				System.out.print(array[endX][i]+"、");
			}
		}
		//从下至上打印一列
		if (endY > start && endX - start > 1) {	//终止列号大于开始列号 并且 终止行号比开始行号至少多2
			for(int i = endX - 1;i> start;i--){
				System.out.print(array[i][start]+"、");
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		matrixPrint(array, 3, 4);
	}

}
