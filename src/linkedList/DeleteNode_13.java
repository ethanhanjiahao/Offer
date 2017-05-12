package linkedList;
/**
 * 13 ��O��1��ʱ��ɾ��������
 * ɾ�����i���ȰѺ�һ�����j���Ƶ�i��֮��ɾ��j���
 * ��Ҫ���ǵ�������� ɾ������β��㣬������next��㣨������Ҫ����ɾ����
 * @author HJH
 *
 */
public class DeleteNode_13 {
	/**
	 * ����ɾ�������ͷ���
	 * @param head
	 * @param deleted
	 * @return
	 */
	public static Node Delete(Node head,Node deleted){
		if (deleted.next!=null) {	//ɾ����㲻��β���
			Node deleteNext = deleted.next;
//			deleted = deleteNext;	//����ǳ���� ��������� �޷����ƶ���
			deleted.value = deleteNext.value;
			deleted.next = deleteNext.next;
		}else if (head.next==null && head == deleted) {	//����ֻ��һ����� ���ұ�ɾ��
			head = null;
		}else {//ɾ�������β��㣬˳��ɾ��
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
