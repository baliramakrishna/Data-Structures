/*package whatever //do not write package name here */

import java.io.*;

class PostOrder{
    
   static void postOrder(int pre[],int start,int end){
        
        if(start>end)
        return;
        int i;
        for(i=start+1;i<=end;i++)
        if(pre[i]>pre[start])
        break;
        
        postOrder(pre,start+1,i-1);
        postOrder(pre,i,end);
        System.out.print(pre[start]+" ");
        
    }
	public static void main (String[] args) {
	
	int pre[]={40 ,30 ,32 ,35 ,80 ,90 ,100 ,120};
	postOrder(pre,0,pre.length-1);
	}
}
