package exercise;

import java.math.BigInteger;

public class FormatConvert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// ʮ����ת16���ƺ�2����
	public static void convert10To2(int n) {
		System.out.println("ʮ����10ת16����Ϊ" + Integer.toHexString(10));
		System.out.println("ʮ����10ת������Ϊ" + Integer.toBinaryString(10));
	}

	// 16����ת10���ƣ�������
	public static void convert16To2(String h) {
		BigInteger srch = new BigInteger(h, 16);

		System.out.println("ʮ�������ַ���10000תΪ10���ƺ�Ϊ:" + srch.toString());// ת��Ϊ10���Ʋ�������
		System.out.println("ʮ�������ַ���10000תΪ2���ƺ�Ϊ" + Integer.toBinaryString(Integer.parseInt(srch.toString())));

		// ����ʹ��16-2
		Integer.toBinaryString(Integer.parseInt("0xAA", 16));
		// 16-10
		Integer.parseInt("0xAA", 16);
	}

	// �ֽ�����ת16�����ַ���
	public static String BinaryToHexString(byte[] bytes) {
		String hexStr = "0123456789ABCDEF";
		String result = "";
		String hex = "";
		for (int i = 0; i < bytes.length; i++) {
			// �ֽڸ�4λ
			hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
			// �ֽڵ�4λ
			hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
			result += hex + " "; // �������ȥ���ո񣬻������0x��ʶ����
		}
		return result;
	}

	//16�����ַ���ת�ֽ�����
	public static byte[] HexStrToBytes(String str) {
		// ����ַ������Ȳ�Ϊż������׷��0
		if (str.length() % 2 != 0) {
			str = "0" + str;
		}

		byte[] b = new byte[str.length() / 2];
		byte c1, c2;
		for (int y = 0, x = 0; x < str.length(); ++y, ++x) {
			c1 = (byte) str.charAt(x);
			if (c1 > 0x60)
				c1 -= 0x57;
			else if (c1 > 0x40)
				c1 -= 0x37;
			else
				c1 -= 0x30;
			c2 = (byte) str.charAt(++x);
			if (c2 > 0x60)
				c2 -= 0x57;
			else if (c2 > 0x40)
				c2 -= 0x37;
			else
				c2 -= 0x30;
			b[y] = (byte) ((c1 << 4) + c2);
		}
		return b;
	}

}
