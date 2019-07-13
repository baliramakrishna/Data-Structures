import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {  
    static boolean fill(int a[][],int n,int row,int col){
        
        
        
        if(col==n){
            col=0;
            row=row+1;
            
            if(row==n)
            return true;
        }
        
        
       
       if(a[row][col]!=0)
       return fill(a,n,row,col+1);
                
                
       for(int k=1;k<=9;k++){
                        
          if(valid(a,n,row,col,k)){
            a[row][col]=k;
            if(fill(a,n,row,col+1))
            return true;
            
          }
       } 
            
      
         a[row][col]=0;
        return false;
        
    } 
     
    static boolean valid(int a[][],int n,int row,int col,int val){
        
        for(int k:a[row]){
            
            if(val==k)
            return false;
        }
        
        for(int i=0;i<n;i++){
            
            if(a[i][col]==val)
            return false;
        }
        
        int p=3;
        
        int I=row/p;
        int J=col/p;
        
        for(int i=0;i<p;i++){
            
            for(int j=0;j<p;j++){
                
                if(val==a[i+I*3][j+J*3])
                return false;
            }
        }
        
       
        return true;
        
    } 
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=9;
           int a[][]=new int[n][n];
           
           for(int i=0;i<n;i++){
               
               for(int j=0;j<n;j++)
               a[i][j]=s.nextInt();
           }
           
         fill(a,n,0,0);
           
           StringBuffer b=new StringBuffer();
           
           for(int i=0;i<n;i++){
               
               for(int j=0;j<n;j++)
               b.append(a[i][j]+" ");
           }
           System.out.println(b);
        
        }
	  
	  
	 }
}
