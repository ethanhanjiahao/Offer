package tree;

import java.util.Stack;

/**
 * 25.二叉树中和某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中结点值和为输入整数的所有路径
 * @author HJH
 *
 */
public class PathInTree_25 {

	/**
	 * 前序遍历的方式访问某一结点，把该结点添加到路径上，并累加结点的值
	 * 如果该结点为叶结点，并且路径中的结点值总和等于输入的整数，则符合要求，打印
	 * 如果不是叶子结点，继续访问非叶结点 的子结点
	 * @param root
	 * @param countNum
	 */
	public static void printPath(BinaryTreeNode root,int exepectNum){
		if (root==null) {
			return;
		}
		Stack<Integer> stack = new Stack<>();
		int currentNum = 0;
		FindPath(root, stack, currentNum, exepectNum);
	}
	
	/**
	 * 寻找路径，如果合适就进行打印
	 * @param root
	 * @param stack
	 * @param currentNum
	 * @param exepectNum
	 */
	public static void FindPath(BinaryTreeNode root,Stack<Integer> stack,int currentNum,int exepectNum){
		currentNum+=root.getValue();
		stack.push(root.getValue());
		if (root.getLeft()==null && root.getRight()==null) {	//到达叶子结点
			if(currentNum==exepectNum){	//路径结点值总和等于指定的整数
				for(Integer s : stack){	//打印栈中元素，不出栈
					System.out.print(s+" ");
				}
				System.out.println();
			}
		}
		if (root.getLeft()!=null) {	//遍历左子树
			FindPath(root.getLeft(), stack, currentNum, exepectNum);
		}
		if (root.getRight()!=null) {	//遍历右子树
			FindPath(root.getRight(), stack, currentNum, exepectNum);
		}
		stack.pop();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeNode root1=new BinaryTreeNode(10);  
        BinaryTreeNode node1=new BinaryTreeNode(5);  
        BinaryTreeNode node2=new BinaryTreeNode(12);  
        BinaryTreeNode node3=new BinaryTreeNode(4);  
        BinaryTreeNode node4=new BinaryTreeNode(7);  
        root1.setLeft(node1); 
        root1.setRight(node2); 
        node1.setLeft(node3); 
        node1.setRight(node4);
        printPath(root1, 22);
	}

}
