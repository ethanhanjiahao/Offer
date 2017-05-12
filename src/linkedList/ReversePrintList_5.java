package linkedList;

import java.util.Stack;
/**5.
 * ����һ�������ͷ��㣬��β��ͷ��������ӡ��ÿ������ֵ
 * @author HJH
 *
 */
public class ReversePrintList_5 {

	//����Stack������ȳ��������
	public static void Reverse1(Node head) {
		Stack<Node > nodeStack = new Stack<Node>();
		while(head!=null){
			nodeStack.push(head);
			head = head.next;
		}
		while(!nodeStack.isEmpty()){
			System.out.print(nodeStack.pop().value);
		}
	}
	
	//�ݹ�ı��ʾ���һ��ջ�ṹ�������õݹ���ʵ��
	public static void Reverse2(Node head) {
		if (head !=null ) {
			if (head.next !=null) {
				Reverse2(head.next);
			}
			System.out.print(head.value);
		}
//		if (head!=null && head.next!=null) {
//			Reverse2(head.next);
//		}
//		System.out.print(head.value);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		Reverse1(head);
		System.out.println();
		Reverse2(null);
	}

}
