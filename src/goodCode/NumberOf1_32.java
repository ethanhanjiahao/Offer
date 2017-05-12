package goodCode;
/**
 * 32����1��n������1���ֵĴ���
 * ����һ������n�����1��n��������ʮ���Ʊ�ʾ��1���ֵĴ���
 * ���� 12 ��1��12ʮ�������У�1һ��������5��
 * @author HJH
 *
 */
public class NumberOf1_32 {

	public static int numOf1(int num){
		if (num == 0) {	//�����ݹ� �ݹ����ֹ����
			return 0;
		}
		int len = getLenOfNum(num);
		int tmp = (int)Math.pow(10, len-1);	//���λ�Ļ��� ���� 21345 --�� 10000
		int first = num/tmp;	//�õ���һ������
		//�ֳ������� ���� 21345-----���� 1-��1345   1346-��21345 �ݹ����
		//�ȿ���1346-��21345
		int firstOneNum = first == 1 ?  num%tmp + 1 : tmp;	//�����һ����1
		int otherOneNum = first * (len-1) * (tmp/10);	//����λ�ֱ���1 ���ֵĴ���---���λ����*��ȥ���λʣ�µ�λ��*ĳһλ�̶�1��ʣ�µı仯��
		
		return firstOneNum + otherOneNum + numOf1(num % tmp);	//�ݹ�ʵ��
		
	}
	
	public static int getLenOfNum(int num){
		int len = 0 ;
		while(num !=0){
			len++;
			num = num/10;
		}
		return len;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numOf1(1));
		System.out.println(numOf1(5));
		System.out.println(numOf1(21345));
	}

}
