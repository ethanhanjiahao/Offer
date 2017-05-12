package string;
/**
 * ����һ���ַ�������ӡ�����ַ����������ַ���ȫ����
 * �����Ҫ�����ֵ��˳���������Ļ��������ת��ΪString����TreeSet���а�װ ���е����������
 * @author HJH
 *
 */
public class StringPermutation_28 {

	public static void permutation(char[] str) {
		if (str == null) {
			return;
		}

		permutation(str, 0);
	}

	//���������п��ܳ����ڵ�һ��λ�õ��ַ������ѵ�һ���ַ��ͺ��������ַ����н���
	//�ڶ������̶���һ���ַ�������������ַ���ȫ����
	private static void permutation(char[] str, int begin) {
		if (begin == str.length) {
			System.out.println(String.valueOf(str));
		}
		else {
			for (int i = begin; i < str.length; i++) {
				char temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;	//����һ���ַ��������ַ���һ����

				permutation(str, begin + 1);	//�Ժ������е��ַ�����ȫ���У��̶���һ���ַ���������ַ���ȫ���У�

				temp = str[begin];
				str[begin] = str[i];
				str[i] = temp;		//����������ַ������������Ա������������ַ����н���

			}
		}
	}

	public static void main(String[] args) {

		char[] str = { 'a', 'b', 'c' };
		permutation(str);
	}
}
