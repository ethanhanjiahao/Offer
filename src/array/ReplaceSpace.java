package array;
/**4.
 * �滻ָ���ַ����еĿո�Ϊ���Ӧ���ַ�
 * �Ӻ���ǰ�滻�����Լ����ƶ�������
 * �Ӻ���ǰ�ȽϺ���Ҫ����һ�����������Ӻ���ǰ�Ƚ�A1��A2�����������飬A1�ռ��㹻��ʹ��A1��A2���Ժϲ���������
 * @author HJH
 *
 */
public class ReplaceSpace {
 
	public static String replace(String str) {
		return str.replaceAll(" ", "%20");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  str = "we are happy.";
		System.out.println(replace(str));
		System.out.println(str);
	}

}
