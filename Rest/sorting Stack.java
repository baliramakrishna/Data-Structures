/*package whatever //do not write package name here */

import java.util.*;

class SortStack{
    
     static Stack<Integer> s=new Stack<>();
     
     static void sort(){
         if(s.isEmpty())
         return;
         else{
             int x=s.pop();
             sort();
             putAtItsPosition(x);
         }
         
     }
     
     static void  putAtItsPosition(int x){
         if(s.isEmpty())
         s.push(x);
         else if(s.peek()<=x)
             s.push(x);
        else{
            int p=s.pop();
            putAtItsPosition(x);
            s.push(p);
        }     
         
     }
	public static void main (String[] args) {
	  
	  s.push(9);
	  s.push(1);
	  s.push(3);
	  s.push(0);
	  s.push(-3);
	  sort();
	  System.out.println(s);
	  
	  
	}
}
