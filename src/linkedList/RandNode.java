package linkedList;
/**
 * �����������������������
 * @author HJH
 *
 */
public class RandNode {
	int value;
	RandNode next;	//�������һ�����
	RandNode rand;	//�������������
	
	public RandNode(int value) {
		super();
		this.value = value;
	}
	
	//��ӡ���������������
	public static void printRandList(RandNode node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
