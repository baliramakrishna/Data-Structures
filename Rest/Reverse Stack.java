/*package whatever //do not write package name here */

import java.util.*;

class ReverseStack{
    
    static Stack<Integer> s=new Stack<>();
    
    static void reverse(){
        
        if(s.isEmpty())
        return;
        else{
            int x=s.pop();
            reverse();
            putAtBottom(x);
        }
        
    }
    
    static void putAtBottom(int x){
        
        if(s.isEmpty())
        s.push(x);
        else{
            int p=s.pop();
            putAtBottom(x);
            s.push(p);
        }
        
    }
	public static void main (String[] args) {
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s);
		reverse();
		System.out.println(s);
		
	}
}
