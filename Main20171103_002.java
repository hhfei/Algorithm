package ZHIHU;

import java.util.Scanner;

public class Main20171103_002 {

	/*
	 * 2给定一字符串只包含数字，请写一个算法，找出该字符串中的最长不重复子串（不重复是指子串中每一元素不同于子串中其他元素） 如：
	 * “120135435”最长不重复子串为 "201354"
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
	 * dp[n]: 以下标为n的元素结尾的最长不重复子串长度
	 * pre: 当前数字上次出现下标
	 * bound: 表示从下标为bound的元素到当前元素无重复
	 * 
	 * 这里dp数组用一个变量preNum表示
	 */


	private static void func(String str) {
		if (str == null) {
			return;
		}
		int[] numIndex = new int[10];// 表示数字最近上次出现的下标
		for (int i = 0; i < 10; i++) {
			numIndex[i] = -1;
		}
		//
		int cur;// 当前数字
		int ansLeft = 0, ansRight = 0;// 保存结果
		int pre = -1;// 当前数字上次出现下标
		int preNum = 0;// 以 上一项元素结尾的最长不重复子串的长度
		int bound = -1;// 表示从下标为bound的元素到当前元素无重复
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
