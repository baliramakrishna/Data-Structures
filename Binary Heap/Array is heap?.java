/*package whatever //do not write package name here */

import java.io.*;

class ArrayIsHeap{
    
   
    public static boolean isHeap(int a[],int n){
        
        for(int i=0;i<=(n-2)/2;i++){
          //right n left should be less than n and left ,right child of every element
          //should b smaller than its parent 
          
         int  l=2*i+1;
          int r=2*i+2;
          //check if it has both children
          if(l<n && r<n){
            if(!(a[i]>a[2*i+1] && a[i]>a[2*i+2]))
            return false;
          }//check if it has only left child
          else 
          if(!(a[i]>a[2*i+1]))
          return false;
            
        }
        return true;
        
    }
	public static void main (String[] args) {
		
		int a[]={90, 15, 10, 7, 1, 2};
		System.out.println(isHeap(a,a.length));
		
	}
}
