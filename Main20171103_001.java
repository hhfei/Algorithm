package ZHIHU;

import java.util.Scanner;

public class Main20171103_001 {

	/*
	 * дһ���㷨�ж�ĳ���ַ����ǲ���һ���Ϸ���IP��ַ�� //˼·������������ʽ�ж�����ַ����ǲ������ֺ͵����ϣ���ʽ��X.X.X.X��
	 * ���ж�X�Ƿ������� [0, 255]��
	 */

	// �Ϸ�IP
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
