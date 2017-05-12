package linkedList;
/**
 * 16、反转链表--
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后的头结点
 * @author HJH
 *
 */
public class ReverseList_16 {

	//反转链表，输出反转后的链表头
	public static Node reverseList(Node head){
		Node reverseHead = null;
		Node pNode = head;	//当前结点
		Node pNodePre = null;		//当前结点的前一个结点
		Node pNodeNext =  null;		//当前结点的后一个结点
		while(pNode != null){
			pNodeNext = pNode.next;
			if (pNodeNext == null) {
				reverseHead = pNode;
			}
			pNode.next = pNodePre;
			pNodePre = pNode;	//结点向后移动，进行反转
			pNode = pNodeNext;
		}
		return reverseHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		Node.printLinkedList(reverseList(head));
	}

}
