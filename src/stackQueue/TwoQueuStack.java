package stackQueue;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ����������ģ��һ��ջ
 * @author HJH
 *
 */
public class TwoQueuStack {
	 	Queue<Integer> queue1 = new ArrayDeque<>();
	    Queue<Integer> queue2 = new ArrayDeque<>();
	    LinkedList<Integer> abc = new LinkedList<>();

	    //�ĸ����в�Ϊ�գ������ĸ�����,���뱣������һ������Ϊ��
	    public void push(int node) {
	        //����ջ��Ϊ��ʱ�����ȿ���queue1
	        if (queue1.isEmpty()&&queue2.isEmpty()) {
	            queue1.add(node);
	            return;
	        }

	        //���queue1Ϊ�գ�queue2��Ԫ�أ�ֱ�ӷ���queue2
	        if (queue1.isEmpty()) {
	            queue2.add(node);
	            return;
	        }

	        if (queue2.isEmpty()) {
	            queue1.add(node);
	            return;
	        }

	    }

	    
	    public int pop() {
	        //����ջ��Ϊ��ʱ��û��Ԫ�ؿ��Ե���
	        if (queue1.isEmpty()&&queue2.isEmpty()) {
	            try {
	                throw new Exception("stack is empty");
	            } catch (Exception e) {
	            }
	        }
	        //���queue1Ϊ�գ�queue2��Ԫ�أ� ��queue2��Ԫ�����η���queue1�У�ֱ�����һ��Ԫ�أ����ǵ�����
	        if (queue1.isEmpty()) {
	            while (queue2.size()>1) {
	                queue1.add(queue2.poll());
	            }
	            return queue2.poll();
	        }

	        if (queue2.isEmpty()) {
	            while (queue1.size()>1) {
	                queue2.add(queue1.poll());
	            }
	            return queue1.poll();
	        }

	        return (Integer) null;
	    }
}
