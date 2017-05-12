package linkedList;
/**
 * 26.复杂链表的复制，实现函数，复制一个复杂链表。在链表中除了每个结点有一个指向下一个结点指针外，还有一个指向链表的任意结点的随机结点
 * 可以采用Map进行映射 时间复杂度为O（1） 用空间换取时间
 * @author HJH
 *
 */
public class CopyComplexList_26 {

	//复制复杂链表
	/**
	 * (1)复制原始链表，生成复制后的链表  N--》N1
	 * (2)设置复制后的链表的随机结点
	 * (3)拆分链表为原始链表和复制后的链表
	 * @param head
	 * @return
	 */
	public static RandNode copyComplex(RandNode head){
		//复制原始链表，1->2-3  1->1'->2->2'->3->3'
		RandNode cur = head;
		RandNode next = null;
		while(cur!=null){
			next = cur.next;
			cur.next = new RandNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		//设置复制后的链表的随机结点
		cur = head;
		next = null;
		while(cur!=null){
			next = cur.next.next;
			cur.next.rand = cur.rand!=null ? cur.rand.next : null;
			cur = next;
		}
		//拆分链表，得到原始链表和复制后的链表（next结点改变）
		cur = head;
		next = null;
		RandNode copyHead = cur.next;
		RandNode curCopy;
		while(cur!=null){
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = cur.next.next;
			curCopy.next = curCopy.next!=null ? curCopy.next.next : null;
			cur = next;
		}
		return copyHead;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandNode head = new RandNode(1);
		RandNode node1 = new RandNode(2);
		RandNode node2 = new RandNode(3);
		head.next = node1;
		head.next.next = node2;
		head.rand = node2;
		node1.rand = node1;
		
		RandNode.printRandList(copyComplex(head));
		System.out.println(copyComplex(head).rand.value);
		
		System.out.println(copyComplex(head).next.rand.value);
	}

}
