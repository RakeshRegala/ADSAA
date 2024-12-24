import java.util.*;
class SelectionSort{

	static void sorting(int p[ ], int n) {
    int i,j,temp,minpos;
    for(i=0; i<n-1; i++)
    {
        minpos=i;
        for(j=i+1; j<n; j++)
            if(p[j]<p[minpos])
                minpos=j;
        temp=p[i];
        p[i]=p[minpos];
        p[minpos]=temp;
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
		System.out.print(A[i]+" ");
	}
}
}
