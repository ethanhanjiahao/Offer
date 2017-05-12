package goodCode;
/**
 * 丑数：只包含因子2,3,5的数。
 * 按从小到达的顺序输出第1500个丑数
 * @author HanJiahao
 *
 */
public class UglyNumber_34 {

	//方法一 按照丑数的定义，逐一判断每个整数是不是丑数
	//方法二 用空间换取时间，创建数组保存已经找到的丑数
	/**
	 * 每一个丑数都是前面的丑数乘以2或3或5得到的数
	 * 从已经排序的丑数数组中，找到一个数M2，小于M2的数*2小于当前丑数数组最大值
	 * 同理 找到M3，M5
	 * 下一个丑数即为min(M2*2,M3*3,M5*5)，加入数组即可
	 * @param args
	 */
	public static int getUgly(int num){
		int[] ugly = new int[num];
		ugly[0] = 1;
		//int indexUgly = 1;
		int minM2 = 0;
		int minM3 = 0;
		int minM5 = 0;
		int index = 1;
		while(index < num){
			ugly[index] = getMin(ugly[minM2]*2, ugly[minM3]*3, ugly[minM5]*5);
			//更新minm2
			while(ugly[minM2]*2 <= ugly[index]) minM2 ++;
			//更新minM3
			while(ugly[minM3]*3 <= ugly[index]) minM3 ++;
			//更新minM5
			while(ugly[minM5]*5 <= ugly[index]) minM5 ++;
			index++;
		}
		return ugly[num-1];
	}
	
	public static int getMin(int a,int b,int c) {
		return (a<b) ? ((a<c) ? a : c) : ((b<c) ?b : c);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getUgly(1500));
	}

}
