package linkedList;
/**
 * 17���ϲ��������������
 * ����������������������ϲ�����������ʹ�ºϲ�������Ľ����Ȼ���յ�������
 * @author HJH
 *
 */
public class MergeSortedList_17 {

	public static Node merge(Node head1,Node head2){
		Node mergeHead = null;	
		//���Ǵ���Ľ�׳��
		if (head1 == null) {
			return head2;
		}else if (head2 == null) {
			return head1;
		}
		if (head1.value < head2.value) {
			mergeHead = head1;	//=ָ����ͬ�Ķ���
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
