package linkedList;
/**
 * 13 在O（1）时间删除链表结点
 * 删除结点i，先把后一个结点j复制到i，之后删除j结点
 * 需要考虑到特殊情况 删除的是尾结点，不存在next结点（还是需要遍历删除）
 * @author HJH
 *
 */
public class DeleteNode_13 {
	/**
	 * 返回删除链表的头结点
	 * @param head
	 * @param deleted
	 * @return
	 */
	public static Node Delete(Node head,Node deleted){
		if (deleted.next!=null) {	//删除结点不是尾结点
			Node deleteNext = deleted.next;
//			deleted = deleteNext;	//属于浅复制 不属于深复制 无法复制对象
			deleted.value = deleteNext.value;
			deleted.next = deleteNext.next;
		}else if (head.next==null && head == deleted) {	//链表只有一个结点 并且被删除
			head = null;
		}else {//删除结点是尾结点，顺序删除
			Node tmp = head;
			while(tmp.next != deleted){
				tmp = tmp.next;
			}
			tmp.next = null;
		}
		return head;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		Node.printLinkedList(Delete(head, head));
	}
	

}
