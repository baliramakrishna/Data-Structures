/*package whatever //do not write package name here */

import java.util.*;

class GFG {
    
    static Stack<Integer> s=new Stack<>();
    
    static void deleteMidElement(){
        
        int n=s.size();
        delete((n)/2 ,0);
    }
    
    static void delete(int n,int count){
        
        if(s.isEmpty())
        return;
        else if(count==n){
          s.pop();
          return;
        }
        else{
            int x=s.pop();
            delete(n,++count);
            s.push(x);
        }
    }
	public static void main (String[] args) {
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		System.out.println(s);
		deleteMidElement();
		System.out.println(s);
	}
}
