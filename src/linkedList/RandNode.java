package linkedList;
/**
 * 含有随机结点的链表，复杂链表
 * @author HJH
 *
 */
public class RandNode {
	int value;
	RandNode next;	//链表的下一个结点
	RandNode rand;	//链表结点的随机结点
	
	public RandNode(int value) {
		super();
		this.value = value;
	}
	
	//打印含有随机结点的链表
	public static void printRandList(RandNode node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
