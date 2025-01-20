import java.io.*;
import java.util.Scanner;

import java.util.Arrays;
public class subset {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.println("Enter the no of elements in array 1");
        n=sc.nextInt();
        int[] a=new int[n];
        System.out.println("Enter the elements in array 1: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }

        int m;
        System.out.println("Enter the no of elements in array 2");
        m=sc.nextInt();
        int[] b=new int[m];
        System.out.println("Enter the elements in array 2: ");
        for(int i=0;i<m;i++){
            b[i]=sc.nextInt();
        }

        if(b.length>a.length){
            System.out.println("False!Array 2 is not subset of Array 1");
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int x=0,y=0,c=0;
        while(x<a.length && y<b.length){
            if(a[x]==b[y]){
                x++;
                y++;
                c++;
            }
            else{
                x++;
            }
        }
        if(c==b.length)
            System.out.println("True!Array 2 is subset of Array 1");
        else
            System.err.println("False!Array 2 is not subset of Array 1");
    }
}
