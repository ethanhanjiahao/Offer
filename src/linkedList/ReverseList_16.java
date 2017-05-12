package linkedList;
/**
 * 16����ת����--
 * ����һ������������һ�������ͷ��㣬��ת�����������ת���ͷ���
 * @author HJH
 *
 */
public class ReverseList_16 {

	//��ת���������ת�������ͷ
	public static Node reverseList(Node head){
		Node reverseHead = null;
		Node pNode = head;	//��ǰ���
		Node pNodePre = null;		//��ǰ����ǰһ�����
		Node pNodeNext =  null;		//��ǰ���ĺ�һ�����
		while(pNode != null){
			pNodeNext = pNode.next;
			if (pNodeNext == null) {
				reverseHead = pNode;
			}
			pNode.next = pNodePre;
			pNodePre = pNode;	//�������ƶ������з�ת
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
