package tree;
/**
 * 18 ��������������  A��B �ж�B�ǲ���A���ӽṹ
 * ��1��������A�в�����B���ڵ�һ���Ľ��
 * ��2�����ж���A����RΪ�����������ǲ��Ǻ���B������ͬ�Ľṹ
 * @author HJH
 *
 */
public class TreeBIsSubTreeA_18 {

	//����A�в�����B�����һ���Ľ��(����������---ǰ�����)
	public static boolean hasSubTree(BinaryTreeNode tree1,BinaryTreeNode tree2){
		boolean result = false;
		if (tree1 != null || tree2 != null) {
			if (tree1.getValue() == tree2.getValue()) {	//��2��
				result = doesTree1HasTree2(tree1, tree2);
			}
			if (!result) {
				result = hasSubTree(tree1.getLeft(), tree2);
			}
			if (!result) {
				result = hasSubTree(tree1, tree2.getRight());
			}
		}
		return result;
	}

	//�ж���A����RΪ�����������ǲ��Ǻ���B������ͬ�ṹ
	public static boolean doesTree1HasTree2(BinaryTreeNode node1,BinaryTreeNode node2){
		if (node2 == null) {	//B�����ȵ���Ҷ�ӽ�㣬����true
			return true;
		}else if (node1 == null) {	//B��δ����Ҷ�ӽ�㣬A�����ȵ���Ҷ�ӽ�㣬����false
			return false;
		}
		
		if (node1.getValue() != node2.getValue()) {
			return false;
		}
		
		return doesTree1HasTree2(node1.getLeft(), node2.getLeft()) && doesTree1HasTree2(node1.getRight(), node2.getRight());
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
       
        BinaryTreeNode root2=new BinaryTreeNode(8);  
        BinaryTreeNode a=new BinaryTreeNode(9);  
        BinaryTreeNode b=new BinaryTreeNode(2);  
        root2.setLeft(a); 
        root2.setRight(b);  
        System.out.println(hasSubTree(root1, root2));  
	}

}
