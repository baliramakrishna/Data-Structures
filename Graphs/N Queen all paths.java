/*package whatever //do not write package name here */

import java.util.*;

class NQUEEN {
    
     static ArrayList<ArrayList<Integer>> l=new ArrayList<>();
    public static void findPositions(int n){
        int a[]=new int[n];
        boolean hasposition=findPositions(a,0,n);
        
    }
    
    public static boolean findPositions(int a[],int row,int n){
        
        if(n==row){
            ArrayList<Integer> m=new ArrayList<>();
            for(int i=0;i<n;i++)
            m.add(a[i]);
            
            l.add(m);
            
            
            return true;
        }
       
        
        for(int col=0;col<n;col++){
            
            boolean safe=true;
            
            for(int queen=0;queen<row;queen++){
                
                //checking for same column,left diagnol,right diagnol
                if(a[queen]==col || queen-a[queen]==row-col || queen+a[queen]==row+col){
                    safe=false;
                    break;
                }
                
            }
            
            if(safe){
             a[row]=col;
             
             if(findPositions(a,row+1,n))
              continue;
             
            }
        }
        
        return false;
    }
    
    
    
	public static void main (String[] args) {
	  
	   int n=10;
	  findPositions(n);
	  
	  for(ArrayList<Integer> m:l){
	      
	      int i=0;
	      for(int k:m){
	          System.out.println(i+" "+k);
	          i++;
	      }
	      System.out.println("................................................................................................................................");
	  } 
	  
	}
}
