package ZHIHU;

public class Main20171009003 {

	/**
	 * ��һ������������������ʹ�����ǵĺ�Ϊһ��ָ������
	 */
	
	/*
	 *  ���������������£�ʱ�临�Ӷ�O(n), �ռ临�Ӷ�O(1)
	 *  ����ֻ�ҳ�һ������������������
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
	 *  ���������������£�ʱ�临�Ӷ�O(n), �ռ临�Ӷ�O(1)
	 *  �����ҳ���������������������
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
