package tree;
/**
 * 24.二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历序列...假设输入数组的任意两个数字互不相同
 * @author HJH
 *
 */
public class SequenceOfBST_24 {

	/**
	 * 后序遍历序列中，最后一个数字是树的根节点的值。
	 * 第一部分都比根结点小，是左子树结点的值
	 * 第二部分都比根节点大，是右子树结点的值
	 * 之后递归判断左子树，递归判断右子树
	 */
	public static boolean VerifySequenceOfBST(int[] array,int start,int length){
		if (array==null || length<=0) {
			return false;
		}
		int root = array[length-1];	//根节点
		int i = 0;
		//找到左子树结点
		while(i<length-1 && array[i]<root){
			if (array[i]<root) {i++;}
		}
		int j = i;	//遍历右子树结点（右子树结点需要全部大于根节点）
		while(j<length-1){
			if (array[j]<root) {	//发现右子树结点小于根结点，返回false
				return false;
			}
			j++;
		}
		
		//递归遍历左子树
		boolean left = true;
		if (i>0) {	//存在左子树
			left = VerifySequenceOfBST(array, 0, i);
		}
		boolean right = true;
		//循环遍历右子树
		if (i<length-1) {	//存在右子树
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
