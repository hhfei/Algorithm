package ZHIHU;

public class Main20170914_001 {

	//最大连续子数组的和
	public static void main(String[] args) {

		int[] arr = {1, -2, 3 , 5, -2, 5};
		
		System.out.println(getMax1(arr));
		System.out.println(getMax2(arr));
	}
	//时间复杂度O(n),空间复杂度O(n)
	public static int getMax1(int[] arr){
		if(arr==null)
			return 0;
		int max=Integer.MIN_VALUE;
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
 		for(int i= 1;i<arr.length;i++){
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			max = Math.max(max, dp[i]);
		}
 		return max;
	}
	
	//时间复杂度O(n),空间复杂度O(1)
	public static int getMax2(int[] arr){
		if(arr==null)
			return 0;
		int max=Integer.MIN_VALUE;
		int pre = 0;
 		for(int i= 0;i<arr.length;i++){
 			pre = Math.max(pre+arr[i], arr[i]);
			max = Math.max(max, pre);
		}
 		return max;
	}

}
