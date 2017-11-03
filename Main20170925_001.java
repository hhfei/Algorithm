package ZHIHU;

import java.util.Scanner;

public class Main20170925_001{
	/*
	 * 两个有序的数组寻找中位数
	 */

	public static void main(String[] args) {

			int[] arr1 = {1,3,5,7};
			int[] arr2 = {2,4,6,8};
			
			System.out.println(get(arr1,arr2));
			
//			System.out.println(findMid(arr1,arr1.length,arr2,arr2.length));
		
	}
	
	static double get(int[]arr1, int[] arr2){
		double rs = 0;
		int[] arr = new int[arr1.length+arr2.length];
		int i=0;
		int j=0;
		int index=0;
		while(i<arr1.length&&j<arr2.length){
			if(arr1[i]>=arr2[j]){
				arr[index++]=arr2[j++];
			}else if(arr1[i]<arr2[j]){
				arr[index++]= arr1[i++];
			}
		}
		while(i<arr1.length){
			arr[index++]= arr1[i++];
		}
		while(j<arr2.length){
			arr[index++]=arr2[j++];
		}
//		for(int k=0;k<arr.length;k++){
//			System.out.print(arr[k]+" ");
//		}
		System.out.println();
		if((arr1.length+arr.length)%2==0){
			return (arr[(arr.length)/2]+arr[(arr.length)/2-1])/2.0;
		}else
			return arr[(arr1.length+arr.length)/2];
			
	}
	
	/*
	 * 
	1） 递归的base条件是，当其中一个数组元素个数只剩下小于等于2时，递归结束
2） 每次递归时，在两个数组中选择除去的元素一定要相等。比如说A数组减去两个元素，那么B数组也要减去两个，这样剩下的区间的中位数和原来的中位数是一样的
	 */

	
	static String findMid(int[] arr1, int from1, int to1,  int[] arr2,int from2, int to2){
		int midA = (from1+to1)/2 ;
		int midB = (from2+to2)/2 ;
		
		
		
		if(arr1[midA]==arr2[midB]){
			return arr1[midA]+"";
		}else if(arr1[midA]<arr2[midB]){
			int len = Math.min(midA-from1, to2-midB);//一次减去的个数保证相同
			return findMid(arr1, from1+len, to1,arr2, from2, to2-len);
		}else{
			int len = Math.min(to1-midA, midB-from2);
			return findMid(arr1,from1,to1-len,arr2,from2+len,to2);
		}
			
	}

}


//if(to1- from1 == 1){
//	if(to2==from2){
//		if((arr1.length+arr2.length)%2==0){
//			return (arr2[from2]+arr1[to1])/2.0 +"";
//		}else{
//			if(arr1[from1]>arr2[from1])
//				return arr1[from1]+"";
//			else
//				return arr2[from2]+"";
//		}
//	}
//}
//
//if(to2- from2 == 1){
//	if(to1==from1){
//		if((arr2.length+arr1.length)%2==0){
//			return (arr1[from1]+arr2[to2])/2.0 +"";
//		}else{
//			if(arr2[from2]>arr1[from2])
//				return arr2[from2]+"";
//			else
//				return arr1[from1]+"";
//		}
//	}
//}
