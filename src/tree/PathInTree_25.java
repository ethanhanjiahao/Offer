package tree;

import java.util.Stack;

/**
 * 25.�������к�ĳһֵ��·��
 * ����һ�ö�������һ����������ӡ���������н��ֵ��Ϊ��������������·��
 * @author HJH
 *
 */
public class PathInTree_25 {

	/**
	 * ǰ������ķ�ʽ����ĳһ��㣬�Ѹý����ӵ�·���ϣ����ۼӽ���ֵ
	 * ����ý��ΪҶ��㣬����·���еĽ��ֵ�ܺ͵�������������������Ҫ�󣬴�ӡ
	 * �������Ҷ�ӽ�㣬�������ʷ�Ҷ��� ���ӽ��
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
	 * Ѱ��·����������ʾͽ��д�ӡ
	 * @param root
	 * @param stack
	 * @param currentNum
	 * @param exepectNum
	 */
	public static void FindPath(BinaryTreeNode root,Stack<Integer> stack,int currentNum,int exepectNum){
		currentNum+=root.getValue();
		stack.push(root.getValue());
		if (root.getLeft()==null && root.getRight()==null) {	//����Ҷ�ӽ��
			if(currentNum==exepectNum){	//·�����ֵ�ܺ͵���ָ��������
				for(Integer s : stack){	//��ӡջ��Ԫ�أ�����ջ
					System.out.print(s+" ");
				}
				System.out.println();
			}
		}
		if (root.getLeft()!=null) {	//����������
			FindPath(root.getLeft(), stack, currentNum, exepectNum);
		}
		if (root.getRight()!=null) {	//����������
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
