package tree;

import java.util.LinkedList;

/**
 * 打印从根结点至叶节点的路径
 * @author HJH
 *
 */
public class PrintPath {

	public static boolean flag = false;
	
	public static void PrintLeafPath(BinaryTreeNode root,BinaryTreeNode leaf,LinkedList<BinaryTreeNode> list){
		if (root == null) {
			return ;
		}
		list.add(root);
		if (root.getLeft() == null && root.getRight() == null) {
			if (root == leaf) {
				flag = true;
				return ;
			}
		}
		if (root.getLeft() !=null) {
			PrintLeafPath(root.getLeft(), leaf, list);
		}
		if (root.getRight() !=null) {
			PrintLeafPath(root.getRight(), leaf, list);
		}
		if (!flag) {
			list.removeLast();
		}

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root1=new BinaryTreeNode(10);  
        BinaryTreeNode node1=new BinaryTreeNode(5);  
        BinaryTreeNode node2=new BinaryTreeNode(12);  
        BinaryTreeNode node3=new BinaryTreeNode(4);  
        BinaryTreeNode node4=new BinaryTreeNode(7);  
        BinaryTreeNode node5=new BinaryTreeNode(15);  
        BinaryTreeNode node6=new BinaryTreeNode(9);  
        root1.setLeft(node1); 
        root1.setRight(node2); 
        node1.setLeft(node3); 
        node1.setRight(node4);
        node2.setLeft(node6);
        node2.setRight(node5);
        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        PrintLeafPath(root1, node5,list);
        for (BinaryTreeNode binaryTreeNode : list) {
			System.out.print(binaryTreeNode.getValue()+ " ");
		}
	}

}
