package ZHIHU;

public class Main20170916_001 {

	/**
	 * 在一个矩阵中寻找一条最大路径,从左上角到右下角，每次只能向右和向下走一步
	 */
	public static void main(String[] args) {

		int[][] arr = {
				{1,2,3},
				{3,4,5},
				{8,7,9}};
		
		System.out.println(getMaxTrace2(arr));
	}
	
	//递归版本
	private static int getMaxTrace1(int[][] arr){
		
		return func(arr,arr.length-1,arr[0].length-1);
	}
	
	private static int func(int[][] arr, int n, int m){
		if(n==0 && m==0)
			return arr[0][0];
		if(n==0)
			return arr[0][m]+func(arr,0,m-1);
		if(m==0)
			return arr[n][0]+func(arr,n-1,0);
		return Math.max(func(arr, n-1, m), func(arr, n, m-1))+arr[n][m];
	}
	
	
	//dp
	private static int getMaxTrace2(int[][] arr){
		int[][] dp = new int[arr.length][arr[0].length];
		dp[0][0] = arr[0][0];
		for(int i=1;i<arr.length;i++){
			dp[i][0] = dp[i-1][0] + arr[i][0];
		}
		for(int i=1;i<arr[0].length;i++){
			dp[0][i] = dp[0][i-1] + arr[0][i];
		}
		
		for(int i=1;i<arr.length;i++){
			for(int j=1;j<arr[0].length;j++){
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]) +arr[i][j];
			}
		}
			
		return dp[arr.length-1][arr[0].length-1];
	}
	
	

}
