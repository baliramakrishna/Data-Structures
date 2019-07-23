 /*
 You have a cupboard with A,B,C pairs of red, green and blue socks respectively. You can take out only 1 sock at a time, without looking. Find the maximum number of times T you must take out a sock till you get N matching pairs, of any colour. (35 marks)
eg A=2, B=4, C=4
N=1 T=4
N=2 T=6
N=4 T=9
N=5 T=10

*/

/*package whatever //do not write package name here */

import java.io.*;

class SocksPairs{
    
    static int max=-10;
    static void count(int a[],int b[],int count,int n){
        
       int p=0;
       
       for(int i=0;i<3;i++){
           p+=b[i]/2;
       }
       
       if(p==n){
           max=Math.max(max,count);
           return;
       }else if(p>n)
       return;
       else{
           
           for(int i=0;i<3;i++){
               if(a[i]==0)
               continue;
               
               a[i]--;
               b[i]++;
               count(a,b,count+1,n);
               a[i]++;
               b[i]--;
           }
           
           
       }
        
    }
	public static void main (String[] args) {
		
		int a[]={2,4,4};
		int b[]=new int[3];
		count(a,b,0,2);
		System.out.println(max);
	}
}
