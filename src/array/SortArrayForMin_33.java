package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 33 把数组排成最小的数
 * @author HanJiahao
 *
 */
public class SortArrayForMin_33 {

	public static void printMinNumber(int[] arr){
		//防止int越界，将数组转换成string数组进行处理。。。大数问题
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
