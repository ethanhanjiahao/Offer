package tree;

/**
 * 6.
 * 输入二叉树的前序遍历和中序遍历，重建该二叉树
 * 
 * @author HJH
 *
 */
public class BinaryTree_6 {
	
	public static BinaryTreeNode getTreeRoot(int[] frontOrder, int[] midOrder) {
		BinaryTreeNode root = new BinaryTreeNode(frontOrder[0]); // 获得根节点
		root.setLeft(null); // 设置右子树
		root.setRight(null); // 设置左子树
		int leftLength = 0;
		// 找到左子树
		for (int i = 0; i < midOrder.length; i++) {
			if (midOrder[i] == root.getValue()) {
				break;
			} else {
				leftLength++;
			}
		}
		int rightLength = midOrder.length - leftLength - 1;

		// 左子树进行递归
		if (leftLength > 0) {
			int[] leftFrontOrder = new int[leftLength]; // 生成新的前序遍历
			int[] leftMIdOrder = new int[leftLength]; // 生成新的中序遍历
			for (int j = 0; j < leftLength; j++) {
				leftFrontOrder[j] = frontOrder[j + 1]; // 前序遍历，根节点后面就是左子树
				leftMIdOrder[j] = midOrder[j]; // 中序遍历，前面全是左子树
			}

			BinaryTreeNode leftRoot = getTreeRoot(leftFrontOrder, leftMIdOrder);
			root.setLeft(leftRoot);
		}
		// 右子树进行递归
		if (rightLength > 0) {
			int[] rightFrontOrder = new int[rightLength];
			int[] rightMidOrder = new int[rightLength];
			for (int j = 0; j < rightLength; j++) {
				rightFrontOrder[j] = frontOrder[j + leftLength + 1];
				rightMidOrder[j] = midOrder[j + leftLength + 1];
			}
			BinaryTreeNode rightRoot = getTreeRoot(rightFrontOrder, rightMidOrder);
			root.setRight(rightRoot);

		}
		return root;
	}

	public static void printPostOrder(BinaryTreeNode root) {
		if (root != null) {
			printPostOrder(root.getLeft());
			printPostOrder(root.getRight());
			System.out.println(root.getValue());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] frontOrder = { 1, 2, 4, 7, 3, 5, 6, 8 };
		int[] inOrder = { 4, 7, 2, 1, 5, 3, 8, 6 };
		BinaryTreeNode root = getTreeRoot(frontOrder, inOrder);
		printPostOrder(root);
	}

}
