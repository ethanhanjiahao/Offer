package linkedList;

import java.util.Stack;
/**5.
 * 输入一个链表的头结点，从尾到头反过来打印出每个结点的值
 * @author HJH
 *
 */
public class ReversePrintList_5 {

	//借助Stack，后进先出进行输出
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
	
	//递归的本质就是一个栈结构，可以用递归来实现
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
