package goodCode;
/**
 * 11 数值的正数次方
 * @author HJH
 *
 */
public class IntegerPower_11 {
	
	public static double powerExponent(double base,int exponent) throws Exception{
		if (exponent<0 && base==0) {
			throw new Exception("除数不能为0");
		}
		double result = PowerWithUnsignedExponent(base, Math.abs(exponent));
		if (exponent <0) {
			result = 1.0/result;
		}
		return result;
	}

	//正数指数的整数乘方
	public static double PowerWithUnsignedExponent(double base, int exponent){
		if (exponent == 0) {
			return 1;
		}
		if (exponent == 1) {
			return base;
		}
		//循环调用
//		double result = 1.0;
//		for(int i=1;i<=exponent;i++){
//			result*=base;
//		}
		double result = PowerWithUnsignedExponent(base, exponent>>1);	//递归调用，减少循环的次数
		result*=result;
		if ((exponent & 1) ==1) {	//判断奇偶次方 ，奇次方， 多乘一次base
			result = result*base;
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(powerExponent(5, -2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
