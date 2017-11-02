package ZHIHU;

public class Main20171009003 {

	/**
	 * 在一个数组中找两个数，使得它们的和为一个指定的数
	 */
	
	/*
	 *  在数组有序的情况下，时间复杂度O(n), 空间复杂度O(1)
	 *  这里只找出一对满足条件的两个数
	 */
	private static void search(int[] arr, int aim){
		if(arr == null || arr.length <2){
			return;
		}
		int i = 0, j= arr.length-1;
		while(i<j){
			if(arr[i] + arr[j] > aim ){
				j--;
			}else if(arr[i] + arr[j] < aim ){
				i++;
			}else{
				System.out.println(arr[i] +"+"+ arr[j] +"="+aim);
				break;
			}
		}
	}
	
	/*
	 *  在数组有序的情况下，时间复杂度O(n), 空间复杂度O(1)
	 *  这里找出所有满足条件的两个数
	 */
	private static void search2(int[] arr, int aim){
		if(arr == null || arr.length <2){
			return;
		}
		int i = 0, j= arr.length-1;
		while(i<j){
			if(arr[i] + arr[j] > aim ){
				j--;
			}else if(arr[i] + arr[j] < aim ){
				i++;
			}else{
				System.out.println(arr[i] +"+"+ arr[j] +"="+aim);
				func(arr, aim, i+1, j);
				func(arr, aim, i, j+1);
				break;
			}
		}
	}
	
	private static void func(int[] arr, int aim ,int i, int j){
		while(i<j){
			if(arr[i] + arr[j] > aim ){
				j--;
			}else if(arr[i] + arr[j] < aim ){
				i++;
			}else{
				System.out.println(arr[i] +"+"+ arr[j] +"="+aim);
				func(arr, aim, i+1, j);
				func(arr, aim, i, j+1);
				break;
			}
		}
	}
	
	public static void main(String[] args) {

		int[] arr = {1,2,4,4,11,11,15};
		int aim = 15;
//		search(arr, aim);
		func(arr, aim, 0 ,arr.length-1);
	}

}
