package goodCode;
/**
 * 12 打印1到最大的n位数
 * 考查对于问题的分析能力，大数问题，采用字符串进行存储，防止越界
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
		boolean end = false;	//控制循环结束
		while(!end){
			charN[n-1]++;	//最后尾加一，需要考虑到进位问题
			for(int i=n-1;i>0;i--){	//从后到前 进行变化
				if (charN[i] == '9'+1) {//考虑进位问题
					charN[i] = '0';
					charN[i-1]++;
				}
			}
			if (charN[0]=='9'+1) {	//结束循环，最高位越界
				end = true;
				break;
			}
			boolean isBegining0 = true;
			for(int i=0;i<=n-1;i++){
				if (isBegining0 && charN[i]!='0') {	//从第一个不是零开始打印
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
