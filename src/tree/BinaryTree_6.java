package tree;

/**
 * 6.
 * �����������ǰ�����������������ؽ��ö�����
 * 
 * @author HJH
 *
 */
public class BinaryTree_6 {
	
	public static BinaryTreeNode getTreeRoot(int[] frontOrder, int[] midOrder) {
		BinaryTreeNode root = new BinaryTreeNode(frontOrder[0]); // ��ø��ڵ�
		root.setLeft(null); // ����������
		root.setRight(null); // ����������
		int leftLength = 0;
		// �ҵ�������
		for (int i = 0; i < midOrder.length; i++) {
			if (midOrder[i] == root.getValue()) {
				break;
			} else {
				leftLength++;
			}
		}
		int rightLength = midOrder.length - leftLength - 1;

		// ���������еݹ�
		if (leftLength > 0) {
			int[] leftFrontOrder = new int[leftLength]; // �����µ�ǰ�����
			int[] leftMIdOrder = new int[leftLength]; // �����µ��������
			for (int j = 0; j < leftLength; j++) {
				leftFrontOrder[j] = frontOrder[j + 1]; // ǰ����������ڵ�������������
				leftMIdOrder[j] = midOrder[j]; // ���������ǰ��ȫ��������
			}

			BinaryTreeNode leftRoot = getTreeRoot(leftFrontOrder, leftMIdOrder);
			root.setLeft(leftRoot);
		}
		// ���������еݹ�
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
