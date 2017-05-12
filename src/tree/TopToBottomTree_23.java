package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 23.���ղ������������
 * �������´�ӡ��������ÿһ����㣬ͬһ���еĽ�㰴�մ����ҵ�˳����д�ӡ
 * @author HJH
 *
 */
public class TopToBottomTree_23 {

	//������������ϵ��±���������
	//ÿһ����ӡһ������ʱ������ý�����ӽڵ㣬��Ѹý����ӽڵ�ŵ�һ������ĩβ���������Ӷ���ͷ��ȡ�����������еĽ�㣬�ظ���ӡ
	//ֱ�����������н�������ӡ����Ϊֹ
	public static void PrintFromTopToBottom(BinaryTreeNode root){
		if (root == null) {	//����׳��
			return;
		}
		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.poll();
			System.out.println(node.getValue());	//��ӡ����ǰ��Ľ��
			//�������ҽ��ӽڵ����������
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
