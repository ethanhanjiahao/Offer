package tree;
/**
 * 18 输入两个二叉树  A和B 判断B是不是A的子结构
 * （1）、在树A中查找与B根节点一样的结点
 * （2）、判断树A中以R为根结点的子树是不是和树B具有相同的结构
 * @author HJH
 *
 */
public class TreeBIsSubTreeA_18 {

	//在树A中查找与B根结点一样的结点(遍历二叉树---前序遍历)
	public static boolean hasSubTree(BinaryTreeNode tree1,BinaryTreeNode tree2){
		boolean result = false;
		if (tree1 != null || tree2 != null) {
			if (tree1.getValue() == tree2.getValue()) {	//（2）
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

	//判断树A中以R为根结点的子树是不是和树B具有相同结构
	public static boolean doesTree1HasTree2(BinaryTreeNode node1,BinaryTreeNode node2){
		if (node2 == null) {	//B树率先到达叶子结点，返回true
			return true;
		}else if (node1 == null) {	//B树未到达叶子结点，A树率先到达叶子结点，返回false
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
