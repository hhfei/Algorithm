package ZHIHU;

public class Main20171017_001 {

	/**
	 * 最长公共子序列
	 */
	public static void main(String[] args) {

//		String input1 = "abcd";
//		String input2 = "padcbd";

		String input1 = "a";
		String input2 = "ab";
//		System.out.println(LCS(input1, input2, input1.length() - 1,
//				input2.length() - 1));
	}

	// 递归版本
	private static int LCS(String input1, String input2, int i, int j) {
		if (i == 0 && j == 0) {
			return input1.charAt(i) == input2.charAt(j) ? 1 : 0;
		}
		if (i == 0) {
			if (input1.charAt(i) == input2.charAt(j))
				return 1;
			else
				return LCS(input1, input2, i, j - 1);
		}
		if (j == 0) {
			if (input1.charAt(i) == input2.charAt(j))
				return 1;
			else
				return LCS(input1, input2, i - 1, j);
		}

		if (input1.charAt(i) == input2.charAt(j)) {
			return LCS(input1, input2, i - 1, j - 1) + 1;
		} else {
			return Math.max(LCS(input1, input2, i, j - 1),
					LCS(input1, input2, i - 1, j));
		}
	}

	// 非递归版本
	private static int LCS2(String input1, String input2) {
		if(input1==null || input2 == null || input1.length()==0 || input2.length()==0)
			return 0;
		
		int[][] dp = new int[input1.length()][input2.length()];
		//初始值，有三种情况
		if(input1.charAt(0)==input2.charAt(0))//情况1
			dp[0][0] = 1;
		else
			dp[0][0] = 0;		
		for(int i=1;i<input2.length();i++){//情况2
			if(input1.charAt(0)==input2.charAt(i)){
				dp[0][i] = 1;
			}else{
				dp[0][i] = dp[0][i-1];
			}
		}		
		for(int i=1;i<input1.length();i++){//情况3
			if(input1.charAt(i)==input2.charAt(0)){
				dp[i][0] = 1;
			}else{
				dp[i][0] = dp[i-1][0];
			}
		}		
		//一般情况
		for(int i=1;i<input1.length();i++)
			for(int j=1;j<input2.length();j++){
				if(input1.charAt(i)==input2.charAt(j)){
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		return dp[input1.length()-1][input2.length()-1];
	}
	
	
	

}
