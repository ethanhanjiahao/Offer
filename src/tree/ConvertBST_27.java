package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 27.输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表
 * @author HJH
 *
 */
public class ConvertBST_27 {

	//法一利用队列等容器收集二叉搜索树中序遍历的结果，二叉搜索树中序遍历完成，已经排序好
	//然后利用队列的出队列，进行next和pre（right和left）的重新组织
	public static TreeNode covert1(TreeNode root){
		Queue<TreeNode> queue = new LinkedList<>();
		MidTravel(root,queue);
		TreeNode head = queue.poll();
		TreeNode pre = head;
		pre.left = null;
		TreeNode cur = null;
		while(!queue.isEmpty()){
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}
	
	//法二利用递归函数，不借助任何容易方法。时间复杂度O（N）
	//1.实现递归函数process，process的功能是将一棵二叉搜索树转换成一个双向链表，双向链表最后一个结点的right指针指向双向链表的第一个结点
	//让最大值结点的right指针指向最小值结点;返回最后一个结点
	//2.根据1中的特殊双向链表，将得到的左子树双向链表的尾结点right指针和根节点相连接；将得到的右子树双向链表的第一个结点的left指针和根节点相连接
	public static TreeNode Convert2(TreeNode root){
		if (root == null) {
			return null;
		}
		TreeNode end = process(root);
		TreeNode head = end.right;
		end.right = null;
		return head;
	}
	
	public static TreeNode process(TreeNode root){
		if (root==null) {
			return null;
		}
		//获得左子树转换成双向链表的开始结点和结束结点；获得右子树转换成双向链表的开始结点和结束结点
		TreeNode leftE = process(root.left);	//左子树的尾指针
		TreeNode rightE = process(root.right);	//右子树的尾指针
		TreeNode leftS = leftE==null ? null : leftE.right;	//左子树的头指针
		TreeNode rightS = rightE== null ? null : rightE.right;	//右子树的头指针
		
		//左子树的双向链表的尾结点和右子树的双向链表的头结点不为空
		if (leftE != null && rightS !=null) {
			leftE.right = root;
			root.left = leftE;
			rightS.left = root;
			root.right = rightS;
			rightE.right = leftS;
			return rightE;
		}else if (leftE == null) {
			rightS.left = root;
			root.right = rightS;
			rightE.right = root;
			return rightE;
		}else if (rightS == null) {
			leftE.right = root;
			root.left = leftE;
			root.right = leftS;
			return root;
		}else {
			root.right = root;
			return root;
		}
	}
	
	//二叉树的中序遍历
	public static void MidTravel(TreeNode root,Queue<TreeNode> queue){
		if (root ==null) {
			return ;
		}
		MidTravel(root.left, queue);
		queue.add(root);
		MidTravel(root.right, queue);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TreeNode {
	public int value;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int value) {
		this.value = value;
	}
}
