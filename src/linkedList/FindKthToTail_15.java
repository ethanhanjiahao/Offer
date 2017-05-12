package linkedList;
/**
 * 15、输入一个链表，输出该链表中倒数第k个结点
 * 定义两个指针，第1个指针先走k-1步，之后 两个指针同时走，直到第一个指针走到链表尾，第2个指针指向的便是倒数第k个结点
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
		for(int i=0;i<k-1;i++){	//第一个指针先走k步
			if (first.next == null) {	//链表不足k个结点
				return null;
			}else {
				first = first.next;
			}
		}
		//从第k步开始，两个指针同时前进
		while(first.next !=null){	//当第一个指针到达链表尾部时，结束循环，此时第二个指针指向的便是倒数第k个结点
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
