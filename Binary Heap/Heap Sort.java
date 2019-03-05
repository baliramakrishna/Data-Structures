/*package whatever //do not write package name here */

import java.io.*;

class HeapSort{
    
    
	public static void main (String[] args) {
		
		int a[]={12, 111, 1, -5, 60, 7};
		int n=a.length;
		HeapSort h=new HeapSort();
		h.sort(a,n);
		
		for(int i:a)
		System.out.print(i+" ");
	}
	
	void sort(int a[],int n){
	    
	    //start from the last root that has child
	    for(int i=(n/2)-1;i>=0;i--)
	    heapify(a,n,i);
	    
	    for(int i=n-1;i>0;i--){
	        
	        int temp=a[i];
	        a[i]=a[0];
	        a[0]=temp;
	        
	        heapify(a,i,0);
	    }
	}
	
	void heapify(int a[],int n,int i){
	    
	    int largest=i;
	    int l=2*i+1;
	    int r=2*i+2;
	    
	    if(l<n && a[l]>a[largest]) largest=l;
	    if(r<n && a[r] > a[largest]) largest=r;
	    
	    if(i!=largest){
	        
	        int temp=a[i];
	        a[i]=a[largest];
	        a[largest]=temp;
	        heapify(a,n,largest);
	    }
	}
	
}
