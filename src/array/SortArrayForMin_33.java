package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 33 �������ų���С����
 * @author HanJiahao
 *
 */
public class SortArrayForMin_33 {

	public static void printMinNumber(int[] arr){
		//��ֹintԽ�磬������ת����string������д���������������
		String[] tmpStrings = new String[arr.length];
		for(int i=0;i<arr.length;i++){
			tmpStrings[i] = String.valueOf(arr[i]);
		}
		Arrays.sort(tmpStrings, new MyCompare());
		for (String string : tmpStrings) {
			System.out.print(string);
		}
	}
	
	static class MyCompare implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			// TODO Auto-generated method stub
			String ab = o1 + o2;
			String ba = o2 + o1;
			return ab.compareTo(ba);
		}	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,32,321};
		printMinNumber(arr);
	}

}
