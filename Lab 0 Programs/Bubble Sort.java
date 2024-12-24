import java.util.*;
public class BubbleSort{

	static void sorting(int a[],int n){
		for(int i=0;i<n-1;i++){
			for(int j=0;j<(n-1-i);j++){
			if(a[j]>a[j+1]){
				int temp=a[j];
				a[j]=a[j+1];
				a[j+1]=temp;
			}
		}
	}
	}
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the no of elements: ");
	int n=sc.nextInt();
	int[] A = new int[n];
	System.out.println("Enter the elements:");
	for (int i = 0; i < n; i++)
		A[i] = sc.nextInt();
	sorting(A,n);
	System.out.println("Sorted array:");
	
	for(int i=0;i<n;i++){
		System.out.print(A[i]);
	}
}
}
