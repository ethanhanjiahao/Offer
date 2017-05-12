package tree;
/**
 * ������������㣬��
 * @author HJH
 *
 */
public class BinaryTreeNode {
	private int value;
	private BinaryTreeNode left;	//��������������
	private BinaryTreeNode right;	//��������������
	
	public BinaryTreeNode(int value) {
		super();
		this.value = value;
	}
	public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
		super();
		this.value = value;
		this.left = left;
		this.right = right;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	//ǰ�����������
	public static void printTree(BinaryTreeNode root){
		if (root !=null) {
			System.out.print(root.getValue());
			printTree(root.getLeft());
			printTree(root.getRight());
		}
	}
}
