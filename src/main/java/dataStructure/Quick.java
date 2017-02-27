package dataStructure;

import java.util.Collections;

//快速排序
public class Quick {
	
	public static void main(String[] args) {
		Quick quick = new Quick();
//		int[] arr =new int[7];
		int[] arr ={36,38,26,57,39,1,29};
		Quick.sort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		//Collections.reverseOrder()
	}
	
	
	public static void sort(int arr[],int low,int high)
	 {
		 int l=low;
		 int h=high;
		 int povit=arr[low];
		 
		 while(l<h)
		 {
			 while(l<h&&arr[h]>=povit)
				 h--;
			 if(l<h){
				 int temp=arr[h];
				 arr[h]=arr[l];
				 arr[l]=temp;
				 l++;
			 }
			 System.out.print(l+"---"+h+"   ");
			 for(int i=0;i<arr.length;i++){System.out.print(arr[i]+"   ");}
			 System.out.println();
			 
			 while(l<h&&arr[l]<=povit)
				 l++;
			 if(l<h){
				 int temp=arr[h];
				 arr[h]=arr[l];
				 arr[l]=temp;
				 h--;
			 }
			 System.out.print(l+"---"+h+"   ");
			 for(int i=0;i<arr.length;i++){System.out.print(arr[i]+"   ");}
			 System.out.println();
		 }
		 System.out.println("l="+(l+1)+"   h="+(h+1)+"   povit="+povit+"\n");
		 if(l>low)
			 sort(arr,low,l-1);
		 if(h<high)
			 sort(arr,l+1,high);
	 }
	
}
