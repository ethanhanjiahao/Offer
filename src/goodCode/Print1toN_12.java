package goodCode;
/**
 * 12 ��ӡ1������nλ��
 * �����������ķ����������������⣬�����ַ������д洢����ֹԽ��
 * @author HJH
 *
 */
public class Print1toN_12 {

	public static void Print1ToMaxNDigits(int n){
		if (n<=0) {
			return ;
		}
		char[] charN = new char[n];
		for(int i=0;i<=n-1;i++){
			charN[i] = '0';
		}
		boolean end = false;	//����ѭ������
		while(!end){
			charN[n-1]++;	//���β��һ����Ҫ���ǵ���λ����
			for(int i=n-1;i>0;i--){	//�Ӻ�ǰ ���б仯
				if (charN[i] == '9'+1) {//���ǽ�λ����
					charN[i] = '0';
					charN[i-1]++;
				}
			}
			if (charN[0]=='9'+1) {	//����ѭ�������λԽ��
				end = true;
				break;
			}
			boolean isBegining0 = true;
			for(int i=0;i<=n-1;i++){
				if (isBegining0 && charN[i]!='0') {	//�ӵ�һ�������㿪ʼ��ӡ
					isBegining0= false;
				}if (!isBegining0) {
					System.out.print(charN[i]);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Print1ToMaxNDigits(2);
	}

}
