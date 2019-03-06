/*package whatever //do not write package name here */

import java.util.*;

class Search{
    
  static int max=1000;
  static boolean h[][]=new boolean[max+1][2];
  
	public static void main (String[] args) {
		

		int a[]={1,-4,45,-34,-23,-9,12};
		int n=a.length;
		insert(a,n);
		System.out.println(search(4));
		
	}
	
	static boolean search(int x){
	    
	    if(x>0){
	        
	        if(h[x][0]==true)
	        return true;
	        else
	        return false;
	    }
	    else{
	    int k=Math.abs(x);
	     
	     if(h[k][1]==true)
	     return true;
	     else return false;
	    }
	}
	
   static void insert(int a[],int n){
       
       for(int i=0;i<n;i++){
           
           if(a[i]>0)
           h[a[i]][0]=true;
           
           else
           h[Math.abs(a[i])][1]=true;
           
           
       }
   }	
	
}
