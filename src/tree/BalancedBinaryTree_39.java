package tree;
/**
 * 39������һ�ö������ĸ��ڵ㣬�жϸ����ǲ���ƽ�������
 * ���ĳ����������������������������������1������ƽ�������
 * @author HJH
 *
 */
public class BalancedBinaryTree_39 {

	//ÿ�����ֻ����һ�εĽⷨ
	/**
	 * �ú�����������������е�ÿһ����㣬�ڱ�����һ�����֮ǰ�������Ѿ�������������������
	 * ֻҪ�ڱ���ÿһ������ʱ���¼�������
	 * @param args
	 */
	public static boolean IsBalanced(BinaryTreeNode root,int depth){
		if (root == null) {
			depth = 0;
			return true;
		}
		int left = 0,right =0;
		//���������˼��
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
