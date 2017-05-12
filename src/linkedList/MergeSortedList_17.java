package linkedList;
/**
 * 17、合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新合并的链表的结点仍然按照递增排序
 * @author HJH
 *
 */
public class MergeSortedList_17 {

	public static Node merge(Node head1,Node head2){
		Node mergeHead = null;	
		//考虑代码的健壮性
		if (head1 == null) {
			return head2;
		}else if (head2 == null) {
			return head1;
		}
		if (head1.value < head2.value) {
			mergeHead = head1;	//=指向相同的对象
			mergeHead.next = merge(head1.next, head2);
		}else {
			mergeHead = head2;
			mergeHead.next = merge(head1, head2.next);
		}
		return mergeHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head1 = new Node(1);
		head1.next = new Node(3);
		head1.next.next = new Node(5);
		head1.next.next.next = new Node(7);
		
		Node head2 = new Node(2);
		head2.next = new Node(3);
		head2.next.next = new Node(6);
		head2.next.next.next = new Node(8);
		Node.printLinkedList(merge(head1, head2));
	}

}
