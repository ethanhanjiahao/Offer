package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 27.����һ�ö��������������ö���������ת����һ�������˫������
 * @author HJH
 *
 */
public class ConvertBST_27 {

	//��һ���ö��е������ռ�������������������Ľ�����������������������ɣ��Ѿ������
	//Ȼ�����ö��еĳ����У�����next��pre��right��left����������֯
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
	
	//�������õݹ麯�����������κ����׷�����ʱ�临�Ӷ�O��N��
	//1.ʵ�ֵݹ麯��process��process�Ĺ����ǽ�һ�ö���������ת����һ��˫������˫���������һ������rightָ��ָ��˫������ĵ�һ�����
	//�����ֵ����rightָ��ָ����Сֵ���;�������һ�����
	//2.����1�е�����˫���������õ���������˫�������β���rightָ��͸��ڵ������ӣ����õ���������˫������ĵ�һ������leftָ��͸��ڵ�������
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
		//���������ת����˫������Ŀ�ʼ���ͽ�����㣻���������ת����˫������Ŀ�ʼ���ͽ������
		TreeNode leftE = process(root.left);	//��������βָ��
		TreeNode rightE = process(root.right);	//��������βָ��
		TreeNode leftS = leftE==null ? null : leftE.right;	//��������ͷָ��
		TreeNode rightS = rightE== null ? null : rightE.right;	//��������ͷָ��
		
		//��������˫�������β������������˫�������ͷ��㲻Ϊ��
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
	
	//���������������
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
