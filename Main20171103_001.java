package ZHIHU;

import java.util.Scanner;

public class Main20171103_001 {

	/*
	 * 写一个算法判断某个字符串是不是一个合法的IP地址。 //思路：先用正则表达式判断这个字符串是不是数字和点的组合（格式：X.X.X.X）
	 * 再判断X是否在区间 [0, 255]中
	 */

	// 合法IP
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			if (isIP(str)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean isIP(String str) {

		if (str == null) {
			return false;
		}
		if (!str.matches("\\d+\\.\\d+.\\d+.\\d+")) {
			return false;
		}

		String[] ss = str.split("\\.");
		for (int i = 0; i < ss.length; i++) {
			int num = Integer.valueOf(ss[i]);
			if (num > 255 || num < 0)
				return false;
		}
		return true;
	}

}
