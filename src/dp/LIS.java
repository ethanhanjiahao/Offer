package dp;
/**
 * 求最长递增子序列
 * @author HJH
 *
 */
public class LIS {
	
	//求最长递增子序列，维护一个数组B【i】：记录长度为i的最长递增子序列中最大元素的最小值
	  public int findLongest(int[] A, int n) {
	        int length = A.length;
	        int[] B = new int[length];
	        B[0] = A[0];
	        int end = 0;
	        for (int i = 1; i < length; ++i) {
	            // 如果当前数比B中最后一个数还大，直接添加
	            if (A[i] >= B[end]) { B[++end] = A[i]; continue;
	            } 
	            // 否则，需要先找到替换位置
	            int pos = findInsertPos(B, A[i], 0, end); B[pos] = A[i];
	        }
	        for (int i = 0; i < B.length; ++i) {
	            System.out.println(B[i]);
	        }
	        return end+ 1; }
	    /**
	     * 二分查找第一个大于等于n的位置
	     */
	    private int findInsertPos(int[] B, int n, int start, int end) {
	        while (start < end) {
	            int mid = start + (end - start) / 2;// 直接使用(high + low) / 2 可能导致溢出
	            if (B[mid] < n) {
	                start = mid + 1;
	            } else if (B[mid] > n) {
	                end = mid ;
	            } else {
	                return mid;
	            }
	        }
	        return start;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
