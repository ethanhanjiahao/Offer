package linkedList;
/**
 * 26.��������ĸ��ƣ�ʵ�ֺ���������һ�����������������г���ÿ�������һ��ָ����һ�����ָ���⣬����һ��ָ��������������������
 * ���Բ���Map����ӳ�� ʱ�临�Ӷ�ΪO��1�� �ÿռ任ȡʱ��
 * @author HJH
 *
 */
public class CopyComplexList_26 {

	//���Ƹ�������
	/**
	 * (1)����ԭʼ�������ɸ��ƺ������  N--��N1
	 * (2)���ø��ƺ�������������
	 * (3)�������Ϊԭʼ����͸��ƺ������
	 * @param head
	 * @return
	 */
	public static RandNode copyComplex(RandNode head){
		//����ԭʼ����1->2-3  1->1'->2->2'->3->3'
		RandNode cur = head;
		RandNode next = null;
		while(cur!=null){
			next = cur.next;
			cur.next = new RandNode(cur.value);
			cur.next.next = next;
			cur = next;
		}
		//���ø��ƺ�������������
		cur = head;
		next = null;
		while(cur!=null){
			next = cur.next.next;
			cur.next.rand = cur.rand!=null ? cur.rand.next : null;
			cur = next;
		}
		//��������õ�ԭʼ����͸��ƺ������next���ı䣩
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
