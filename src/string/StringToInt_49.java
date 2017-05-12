package string;
/**
 * ��Stringת����intֵ������ע���쳣ֵ��Խ����������Ŀ���
 * @author HJH
 *
 */
public class StringToInt_49 {

	
	/**
	 * �쳣���
	 * ��ͷ���ֿո�
	 * ��һ���ַ�Ϊ�����ţ����ַ�����
	 * Խ��
	 * @param str
	 * @return
	 */
	public static int myAtoi(String str) {
		int result = 0;
		str = str.trim();	//ȥ����ͷ�Ŀո�
		char[] charStr = str.toCharArray();
		boolean position = true;
		for(int i=0;i<charStr.length;i++){
			char c = charStr[i];
			if (i==0 && (c=='-' || c=='+')) {
				position = c=='-' ? false : true;
			}else if (c>='0' && c<='9') {	//Ϊ����
				//�ж��Ƿ�Խ��
				if (result > ((Integer.MAX_VALUE - c - '0') / 10)) {
					return position ? Integer.MAX_VALUE : Integer.MIN_VALUE;
				}
				result = result*10 + c-'0';
			}else {	//������һ�������� ֱ�ӷ���
				return position ? result : -result;
			}
		}
	    return position ? result : -result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
