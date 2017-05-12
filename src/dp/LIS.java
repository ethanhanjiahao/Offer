package dp;
/**
 * �������������
 * @author HJH
 *
 */
public class LIS {
	
	//������������У�ά��һ������B��i������¼����Ϊi������������������Ԫ�ص���Сֵ
	  public int findLongest(int[] A, int n) {
	        int length = A.length;
	        int[] B = new int[length];
	        B[0] = A[0];
	        int end = 0;
	        for (int i = 1; i < length; ++i) {
	            // �����ǰ����B�����һ��������ֱ�����
	            if (A[i] >= B[end]) { B[++end] = A[i]; continue;
	            } 
	            // ������Ҫ���ҵ��滻λ��
	            int pos = findInsertPos(B, A[i], 0, end); B[pos] = A[i];
	        }
	        for (int i = 0; i < B.length; ++i) {
	            System.out.println(B[i]);
	        }
	        return end+ 1; }
	    /**
	     * ���ֲ��ҵ�һ�����ڵ���n��λ��
	     */
	    private int findInsertPos(int[] B, int n, int start, int end) {
	        while (start < end) {
	            int mid = start + (end - start) / 2;// ֱ��ʹ��(high + low) / 2 ���ܵ������
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
