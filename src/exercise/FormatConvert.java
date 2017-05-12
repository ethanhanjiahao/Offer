package exercise;

import java.math.BigInteger;

public class FormatConvert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 十进制转16进制和2进制
	public static void convert10To2(int n) {
		System.out.println("十进制10转16进制为" + Integer.toHexString(10));
		System.out.println("十进制10转二进制为" + Integer.toBinaryString(10));
	}

	// 16进制转10进制，二进制
	public static void convert16To2(String h) {
		BigInteger srch = new BigInteger(h, 16);

		System.out.println("十六进制字符串10000转为10进制后为:" + srch.toString());// 转换为10进制并输出结果
		System.out.println("十六进制字符串10000转为2进制后为" + Integer.toBinaryString(Integer.parseInt(srch.toString())));

		// 或者使用16-2
		Integer.toBinaryString(Integer.parseInt("0xAA", 16));
		// 16-10
		Integer.parseInt("0xAA", 16);
	}

	// 字节数组转16进制字符串
	public static String BinaryToHexString(byte[] bytes) {
		String hexStr = "0123456789ABCDEF";
		String result = "";
		String hex = "";
		for (int i = 0; i < bytes.length; i++) {
			// 字节高4位
			hex = String.valueOf(hexStr.charAt((bytes[i] & 0xF0) >> 4));
			// 字节低4位
			hex += String.valueOf(hexStr.charAt(bytes[i] & 0x0F));
			result += hex + " "; // 这里可以去掉空格，或者添加0x标识符。
		}
		return result;
	}

	//16进制字符串转字节数组
	public static byte[] HexStrToBytes(String str) {
		// 如果字符串长度不为偶数，则追加0
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
