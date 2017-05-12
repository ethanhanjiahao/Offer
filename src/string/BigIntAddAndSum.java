package string;
/**
 * ������Ӻ����
 * @author HJH
 *
 */
public class BigIntAddAndSum {

	public static void main(String[] args) {

		String a = "4632864832684683568465765487657665765236465244";
		String b = "47";
		int[] pa = stringToInts(a);
		int[] pb = stringToInts(b);
		String ans_add = add(pa, pb);
		String ans_sub = sub(pb, pa);
		System.out.println("��ӽ���ǣ�" + ans_add);
		System.out.println("�������ǣ�" + ans_sub);
	}

	/**
	 * ��String��ת����int����
	 * 
	 * @param s
	 * @return
	 */
	public static int[] stringToInts(String s) {
		int[] n = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			n[i] = Integer.parseInt(s.substring(i, i + 1));
		}
		return n;
	}

	public static String add(int[] a, int[] b) {
		StringBuffer sb = new StringBuffer();
		int a_len = a.length - 1;
		int b_len = b.length - 1;
		int jinwei = 0;// ��λ
		while (a_len >= 0 || b_len >= 0) {
			int temp = 0;
			if (a_len >= 0 && b_len >= 0) {
				temp = a[a_len] + b[b_len] + jinwei;
			} else if (a_len >= 0) {
				temp = a[a_len] + jinwei;
			} else if (b_len >= 0) {
				temp = b[b_len] + jinwei;
			}
			sb.append(temp % 10 + "");
			jinwei = temp / 10;
			a_len--;
			b_len--;
		}
		return getNum(sb.reverse());
	}

	public static String sub(int[] a, int[] b) {
		StringBuffer sb = new StringBuffer();
		boolean flag = false;// �ж�a�ǲ��Ǳ�bС
		if (a.length < b.length) {
			int c[] = a;
			a = b;
			b = c;// ����һ��
			flag = true;
		}
		int a_len = a.length - 1;
		int b_len = b.length - 1;
		int jiewei = 0;// ��λ
		while (a_len >= 0 || b_len >= 0) {
			int temp = 0;
			if (a_len >= 0 && b_len >= 0) {
				if ((a[a_len] - jiewei) < b[b_len]) {
					temp = a[a_len] + 10 - b[b_len] - jiewei;
					jiewei = 1;
				} else {
					temp = a[a_len] - b[b_len] - jiewei;
				}
			} else if (a_len >= 0) {
				temp = a[a_len] - jiewei;
				jiewei = 0;
			}
			sb.append(temp + "");

			a_len--;
			b_len--;
		}
		if (flag) {
			return getNum(sb.append("-").reverse());
		}
		return getNum(sb.reverse());
	}

	// ȥ����ǰ���0
	public static String getNum(StringBuffer sb) {
		while (sb.length() > 1 && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}
		return sb.toString();
	}

}
