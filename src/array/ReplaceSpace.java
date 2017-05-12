package array;
/**4.
 * 替换指定字符串中的空格为相对应的字符
 * 从后向前替换，可以减少移动次数；
 * 从后向前比较很重要，举一反三：：：从后向前比较A1，A2两个有序数组，A1空间足够大，使得A1，A2可以合并最终有序
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
