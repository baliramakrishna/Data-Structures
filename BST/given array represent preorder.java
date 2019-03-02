/*package whatever //do not write package name here */

import java.util.*;

class ArrayPre{
    
    
    static boolean arraypreorder(int a[],int l){
        
        int root=Integer.MIN_VALUE;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<l;i++){
            
           if(root>a[i])
           return false;
           
           while(!s.isEmpty() && s.peek()<a[i]){
               
               root=s.peek();
               s.pop();
           }
           s.push(a[i]);
        }
        return true;
    }
	public static void main (String[] args) {
		
		int a[]={5,3,2,4,9,7,11,10};
		System.out.println(arraypreorder(a,a.length));
	}
}
