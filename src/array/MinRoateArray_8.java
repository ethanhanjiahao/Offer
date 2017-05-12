package array;
/**
 * 8.旋转数组中的最小值（二分查找）
 * @author HJH
 *
 */
public class MinRoateArray_8 {

	//返回旋转数组中的最小值
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
		//保证是旋转数组
		while(array[index1] >= array[index2]){
			//当后面的index2比index1大1时，结束循环，index2为最小值的下标
			if (index2 - index1 ==1) {
				indexMid = index2;
				break;
			}
			
			indexMid = (index2+index1)/2;
			//顺序查找	[1,1,0,1,1,1,1] [1,1,1,1,0,1,1];不确定最小值在左边还是在右边
			if (array[index1] == array[index2]) {
				return MinOrderArray(array,index1,index2);
			}else if (array[indexMid] >= array[index1]) {	//二分查找的思想
				index1 = indexMid;
			}else if (array[indexMid] <= array[index2]) {
				index2 = indexMid;
			}
		}
		return array[indexMid];
	}
	
	//顺序查找数组中的最小值
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
