package tree;
/**
 * 19.二叉树的镜像
 * 输入一个二叉树，输出它的镜像
 * 画图让抽象问题具体化，交换所有非叶结点的左右子节点
 * @author HJH
 *
 */
public class MirrorOfBinaryTree_19 {

	/**
	 * 递归实现，找到递归的终止条件
	 * @param root 二叉树的根节点，根节点不用交换，交换左右子节点的位置
	 */
	public static void recursiveMirror(BinaryTreeNode root){
		if (root == null) {
			return ;
		}
		//递归的终止条件，到达叶子结点，终止递归
		if (root.getLeft() == null && root.getRight() == null) {
			return;
		}
		BinaryTreeNode tmp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(tmp);
		
		//递归遍历左结点
		if (root.getLeft()!=null) {
			recursiveMirror(root.getLeft());
		}
		//递归遍历右节点
		if (root.getRight() !=null) {
			recursiveMirror(root.getRight());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root1=new BinaryTreeNode(8);  
        BinaryTreeNode node1=new BinaryTreeNode(8);  
        BinaryTreeNode node2=new BinaryTreeNode(7);  
        BinaryTreeNode node3=new BinaryTreeNode(9);  
        BinaryTreeNode node4=new BinaryTreeNode(2);  
        BinaryTreeNode node5=new BinaryTreeNode(4);  
        BinaryTreeNode node6=new BinaryTreeNode(7);  
        root1.setLeft(node1);
        root1.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node4.setLeft(node5); 
        node4.setRight(node6); 
        BinaryTreeNode.printTree(root1);
		System.out.println();
        recursiveMirror(root1);
        BinaryTreeNode.printTree(root1);
	}

}
