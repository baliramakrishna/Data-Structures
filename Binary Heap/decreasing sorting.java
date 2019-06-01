/*package whatever //do not write package name here */

import java.util.*;

class MinHeap{
    
    
    static void sort(int a[],int n){
        
        for(int i=(n/2)-1;i>=0;i--)
        heapify(a,n,i);
        
        for(int i=n-1;i>0;i--){
            
            int temp=a[0];
            a[0]=a[i];
            a[i]=temp;
            heapify(a,i,0);
            
        }
        
    }
    
    static void heapify(int a[],int n,int i){
        
        int left=2*i+1;
        int right=2*i+2;
        int smallest=i;
        
        if(left<n && a[left]<a[smallest]) smallest=left;
        
        if(right<n && a[right]<a[smallest]) smallest=right;
        
        if(smallest!=i){
            
           int temp=a[smallest];
           a[smallest]=a[i];
           a[i]=temp;
            
            heapify(a,n,smallest);
        }
        
        
        
    }
    
	public static void main (String[] args) {
		
		int a[]={1,5,9,3,54,12,9,123};
		sort(a,a.length);
		
		for(int k:a)
		System.out.print(k+" ");
		
		
	}
}
