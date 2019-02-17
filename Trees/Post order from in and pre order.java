/*package whatever //do not write package name here */

import java.util.*;

class PostOrder{
    static int preindex=0;
    
    void postOrder(int in[],int pre[]){
        
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<in.length;i++){
            
            h.put(in[i],i);
        }
        printPostOrder(h,in,pre,0,in.length-1);
    }
    
    void printPostOrder(HashMap<Integer,Integer> h,int in[],int pre[],int start,int end){
        
        if(start>end)
        return;
        
        int index=h.get(pre[preindex++]);
        printPostOrder(h,in,pre,start,index-1);
        printPostOrder(h,in,pre,index+1,end);
        System.out.print(in[index]+" ");
        
        
    }
    
	public static void main (String[] args) {
		
		int in[] = { 4, 2, 5, 1, 3, 6 };  
        int pre[] = { 1, 2, 4, 5, 3, 6 }; 
        
        PostOrder p=new PostOrder();
        p.postOrder(in,pre);
	}
}
