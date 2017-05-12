package tree;
/**
 * 19.�������ľ���
 * ����һ����������������ľ���
 * ��ͼ�ó���������廯���������з�Ҷ���������ӽڵ�
 * @author HJH
 *
 */
public class MirrorOfBinaryTree_19 {

	/**
	 * �ݹ�ʵ�֣��ҵ��ݹ����ֹ����
	 * @param root �������ĸ��ڵ㣬���ڵ㲻�ý��������������ӽڵ��λ��
	 */
	public static void recursiveMirror(BinaryTreeNode root){
		if (root == null) {
			return ;
		}
		//�ݹ����ֹ����������Ҷ�ӽ�㣬��ֹ�ݹ�
		if (root.getLeft() == null && root.getRight() == null) {
			return;
		}
		BinaryTreeNode tmp = root.getLeft();
		root.setLeft(root.getRight());
		root.setRight(tmp);
		
		//�ݹ��������
		if (root.getLeft()!=null) {
			recursiveMirror(root.getLeft());
		}
		//�ݹ�����ҽڵ�
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
