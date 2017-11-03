package ZHIHU;

import java.util.Scanner;

public class Main20171103_002 {

	/*
	 * 2����һ�ַ���ֻ�������֣���дһ���㷨���ҳ����ַ����е�����ظ��Ӵ������ظ���ָ�Ӵ���ÿһԪ�ز�ͬ���Ӵ�������Ԫ�أ� �磺
	 * ��120135435������ظ��Ӵ�Ϊ "201354"
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String input = sc.next();
			func(input);
		}
	}

	/*
	 * dp[n] = dp[n-1]+1,    pre==-1
	 *       = i-pre,        pre!=-1
	 *       = i-bound+1,   pre!=-1
	 * dp[n]: ���±�Ϊn��Ԫ�ؽ�β������ظ��Ӵ�����
	 * pre: ��ǰ�����ϴγ����±�
	 * bound: ��ʾ���±�Ϊbound��Ԫ�ص���ǰԪ�����ظ�
	 * 
	 * ����dp������һ������preNum��ʾ
	 */


	private static void func(String str) {
		if (str == null) {
			return;
		}
		int[] numIndex = new int[10];// ��ʾ��������ϴγ��ֵ��±�
		for (int i = 0; i < 10; i++) {
			numIndex[i] = -1;
		}
		//
		int cur;// ��ǰ����
		int ansLeft = 0, ansRight = 0;// ������
		int pre = -1;// ��ǰ�����ϴγ����±�
		int preNum = 0;// �� ��һ��Ԫ�ؽ�β������ظ��Ӵ��ĳ���
		int bound = -1;// ��ʾ���±�Ϊbound��Ԫ�ص���ǰԪ�����ظ�
		int max = -1;
		for (int i = 0; i < str.length(); i++) {
			cur = str.charAt(i) - '0';

			pre = numIndex[cur];
			if (pre == -1) {
				preNum++;

			} else {
				if (pre < bound) {
					preNum = i - bound + 1;
				} else {
					preNum = i - pre;
				}
				bound = Math.max(bound, pre + 1);
			}
			numIndex[cur] = i;
			if (max < preNum) {
				ansLeft = i - preNum + 1;
				ansRight = i;
				max = preNum;
			}
		}

		//
		System.out.print(str.substring(ansLeft, ansRight + 1));
		// System.out.println("   max= "+max);

	}

}
