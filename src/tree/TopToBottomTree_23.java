package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 23.按照层序遍历二叉树
 * 从上往下打印二叉树中每一个结点，同一层中的结点按照从左到右的顺序进行打印
 * @author HJH
 *
 */
public class TopToBottomTree_23 {

	//层序遍历，从上到下遍历二叉树
	//每一个打印一个结点的时候，如果该结点有子节点，则把该结点的子节点放到一个队列末尾；接下来从队列头部取出最早进入队列的结点，重复打印
	//直到队列中所有结点均被打印出来为止
	public static void PrintFromTopToBottom(BinaryTreeNode root){
		if (root == null) {	//程序健壮性
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.poll();
			System.out.println(node.getValue());	//打印队列前面的结点
			//从左至右将子节点加入至队列
			if (node.getLeft() !=null) {
				queue.add(node.getLeft());
			}
			if (node.getRight() !=null) {
				queue.add(node.getRight());
			}
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
        PrintFromTopToBottom(root1);
	}

}
