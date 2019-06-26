/*

How many ways are there to place a black and a white knight on an N * M chessboard such that they do not attack each other?
The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), 
or two squares vertically and one square horizontally (L shaped).
The knights attack each other if one can reach the other in one move.

*/


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {   
     static int row[]={1,1,2,2,-1,-1,-2,-2};
     static int coloumn[]={2,-2,1,-1,2,-2,1,-1};
     
     static int moves(int n,int m){
         
         int count=0;
         int total=n*m;
         for(int i=0;i<n;i++){
             

             for(int j=0;j<m;j++){
                 
                 int moves=1;
                 
                 for(int k=0;k<8;k++){
                     
                     int r=i+row[k];
                     int c=j+coloumn[k];
                     
                     if(r>=0 && c>=0 && r<n && c<m )
                     moves++;
                 }
                 
                 count+=(total-moves);
                 
             }
         }
         
         return count;
     }
     
     
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           int m=s.nextInt();
           
           System.out.println(moves(n,m)); 
        
        }
	  
	  
	 }
}
