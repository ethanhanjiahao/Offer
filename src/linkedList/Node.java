package linkedList;

public class Node {
	public int value;
	public Node next;
	
	public Node(int value){
		this.value = value;
	}
	
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
