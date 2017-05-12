package tree;
/**
 * 39：输入一棵二叉树的根节点，判断该树是不是平衡二叉树
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，则是平衡二叉树
 * @author HJH
 *
 */
public class BalancedBinaryTree_39 {

	//每个结点只遍历一次的解法
	/**
	 * 用后序遍历遍历二叉树中的每一个结点，在遍历到一个结点之前，我们已经遍历了它的左右子树
	 * 只要在遍历每一个结点的时候记录它的深度
	 * @param args
	 */
	public static boolean IsBalanced(BinaryTreeNode root,int depth){
		if (root == null) {
			depth = 0;
			return true;
		}
		int left = 0,right =0;
		//后序遍历的思想
		if (IsBalanced(root.getLeft(), left) && IsBalanced(root.getRight(), right)) {
			int diff = left - right;
			if (diff <=1 && diff>=-1) {
				depth = 1 + (left > right ? left :right );
				return true;
			}
		}
		return false;
	}
	
	public static boolean IsBalanced(BinaryTreeNode root){
		int depth = 0;
		return IsBalanced(root, depth);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
