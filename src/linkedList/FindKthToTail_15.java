package linkedList;
/**
 * 15������һ����������������е�����k�����
 * ��������ָ�룬��1��ָ������k-1����֮�� ����ָ��ͬʱ�ߣ�ֱ����һ��ָ���ߵ�����β����2��ָ��ָ��ı��ǵ�����k�����
 * @author HJH
 *
 */
public class FindKthToTail_15 {

	public static Node findKthNode(Node head,int k){
		if (head == null || k==0) {
			return null;
		}
		Node first = head;
		Node second = head;
		for(int i=0;i<k-1;i++){	//��һ��ָ������k��
			if (first.next == null) {	//������k�����
				return null;
			}else {
				first = first.next;
			}
		}
		//�ӵ�k����ʼ������ָ��ͬʱǰ��
		while(first.next !=null){	//����һ��ָ�뵽������β��ʱ������ѭ������ʱ�ڶ���ָ��ָ��ı��ǵ�����k�����
			first = first.next;
			second = second.next;
		}
		return second;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		System.out.println(findKthNode(head, 3).value);
	}

}
