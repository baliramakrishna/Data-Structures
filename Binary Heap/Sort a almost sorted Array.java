/*package whatever //do not write package name here */

import java.io.*;

class AlmostSorted{
    
    int heap[];
    int k;
    
    AlmostSorted(int k){
        this.k=k;
        heap=new int[k+1];
    }
	public static void main (String[] args) {
		
		
		int a[]={10, 9, 8, 7, 4, 70, 60, 50};
		int k=4;
		AlmostSorted s=new AlmostSorted(k);
		s.sort(a,k,a.length);
		
		for(int i:a)
		System.out.print(i+" ");
	}
	
	void sort(int a[],int k,int n){
	    
	    //insert first k+1 elements into the heap
	    for(int i=0;i<=k;i++)
	    heap[i]=a[i];
	    
	    //heapify first k+1 elements
	    
	    for(int i=(k+1)/2-1;i>=0;i--)
	    heapify(k+1,i);
	    
	    for(int i=k+1;i<n;i++){
	        
	        a[i-(k+1)]=heap[0];
	        heap[0]=a[i];
	        heapify(k+1,0);
	    }
	    
	    int p=n-(k+1);
	    a[p++]=heap[0];
	    heap[0]=heap[k];
	    

	    for(int i=k;i>0 && p<n;i--){
	        
	        heapify(i,0);
	        a[p++]=heap[0];
	        heap[0]=heap[i-1];
	    }
	    
	    
	}
	
	void heapify(int n,int i){
	     
	    int small=i;
	    int l=2*i+1;
	    int r=2*i+2;
	    if(l<n &&heap[l]<heap[small]) small=l;
	    if(r<n && heap[r]<heap[small]) small=r;
	    
	    if(small!=i){
	        
	        int temp=heap[i];
	        heap[i]=heap[small];
	        heap[small]=temp;
	        heapify(n,small);
	        
	    }
	    
	    
	}
}
