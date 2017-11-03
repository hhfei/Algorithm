package ZHIHU;

public class Main20171014_001 {

	/*
	 * https://www.nowcoder.com/questionTerminal/9f3231a991af4f55b95579b44b7a01ba
	 */
	public static void main(String[] args) {

		int[] arr = {3,4,5,1,2};
//		int[] arr = {1,2,3,4,5};
		System.out.println(bSearch(arr));
	}

	
	
	private static int bSearch(int[] arr){
		if(arr==null){
			return 0;
		}
		int i=0;
		int j=arr.length-1;
		int mid=-1;
		
		while(arr[i]>=arr[j]){
			mid = (i+j)/2;
			if(j-i==1){
				mid = j;
				break;
			}
			if(arr[mid] <= arr[j]){
				j=mid;
			}
			
			if(arr[mid] >= arr[i]){
				i=mid;
			}
		}
		if(mid!=-1)
			return arr[mid];
		return -1;
	}
}
