/*package whatever //do not write package name here */

import java.io.*;

class MinHeap{
    
    int maxsize;
    int size;
    int heap[];
    
    MinHeap(int maxsize){
        
        this.maxsize=maxsize;
        heap=new int[maxsize];
    }
    
    int parent(int i){
        
        return (i-1)/2;
    }
    
    int left(int i){
        return 2*i+1;
    }
    
    int right(int i){
        
        return 2*i+2;
    }
    
    void swap(int i,int p){
        
        int temp=heap[i];
        heap[i]=heap[p];
        heap[p]=temp;
    }
    void insert(int k){
        
        if(heap.length>maxsize){
            System.out.println("Heap Overflow");
            return;
        }
        
        heap[size++]=k;
        int i=size-1;
        
        while(i!=0 && heap[parent(i)]>heap[i]){
            
            swap(i,parent(i));
            i=parent(i);
        }
        
    }
    
    void deleteAtIndex(int k){
        
        decreaseIndex(k,Integer.MIN_VALUE);
        extractMin();
        
    }
    
    void decreaseIndex(int k,int min){
        
        heap[k]=min;
        
        int i=k;
        while(i!=0 && heap[parent(i)]>heap[i]){
            swap(i,parent(i));
            i=parent(i);
        }
        
    }
    
    void extractMin(){
        
       if(size==0)
       return;
       
       if(size==1){
           size--;
           return;
       }
       
       heap[0]=heap[size-1];
       size--;
       minHeapify(0);
    }
    
    void minHeapify(int k){
        
        int left=left(k);
        int right=right(k);
        int small=k;
        
        if(left<size && heap[left]<heap[k]) small=left;
        if(right<size && heap[right]<heap[k]) small=right;
        
        if(small!=k){
            
            swap(k,small);
            minHeapify(small);
        }
        
    }
    
    void print(){
        
        for(int i=0;i<size;i++)
        System.out.print(heap[i]+" ");
        System.out.println();
    }
	public static void main (String[] args) {
	  
	  MinHeap m=new MinHeap(12);
	  m.insert(3);
	  m.insert(2);
	  m.insert(1);
	  m.insert(15);
	  m.insert(5);
	  m.insert(4);
	  m.insert(45);
	  m.print();
	  m.deleteAtIndex(3);
	  m.print();
	   
	  
	}
}
