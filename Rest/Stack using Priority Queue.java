/*package whatever //do not write package name here */

import java.util.*;

class HeapStack{
    static PriorityQueue<Pair> q=new PriorityQueue<>(new StackComparator());
    static int count=0;
    static class Pair {
        
        int data;
        int priority;
        
        Pair(int data,int priority){
            
            this.data=data;
            this.priority=priority;
        }
        
    }
    
    static class StackComparator implements Comparator<Pair>{
        
        @Override
        
        public int compare(Pair p1,Pair p2){
            
            if(p1.priority>p2.priority)
            return -1;
            else if(p1.priority<p2.priority)
            return +1;
            else
            return 0;
        }
        
    }
    static void push(int x ){
        
        q.add(new Pair(x,count++));
        
    }
    static int pop(){
        
        if(!q.isEmpty())
        return q.poll().data;
        else
        return -1;
    }
    
    
	public static void main (String[] args) {
	  
	  push(1);
	  push(2);
	  push(3);
	  System.out.println(pop());
	 
	}
}
