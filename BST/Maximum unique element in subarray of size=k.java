/*package whatever //do not write package name here */

import java.util.*;

class UniqueSet {
    
    static void printUnique(int a[],int k,int n){
        
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        TreeSet<Integer> t=new TreeSet<>();
        
        for(int i=0;i<k-1;i++){
            
            if(h.containsKey(a[i]))
            h.put(a[i],h.get(a[i])+1);
            else
            h.put(a[i],1);
        }
        
        for(int p:h.keySet()){
            
            if(h.get(p)==1)
            t.add(p);
            
        }
        for(int i=k-1;i<n;i++){
            
            if(h.containsKey(a[i])){
            h.put(a[i],h.get(a[i])+1);
            
            if(t.contains(a[i]))
            t.remove(a[i]);
            
            }else {
                
                h.put(a[i],1);
                t.add(a[i]);
            }
            
            if(!t.isEmpty())
            System.out.print(t.first()+" ");
            else
            System.out.print("Nothing ");
            
            int x=a[i-k+1];
            
            //if first elements count is 1,delete it from hashmap and tree set
            if(h.get(x)==1){
            h.remove(x);
            t.remove(x);
            }
            //if count is 2 ,decrement count in hashmap and add it in tree set
            else if(h.get(x)==2){
            h.put(x,h.get(x)-1);
            t.add(x);
            }else h.put(x,h.get(x)-1);
           
            
            
        }
        
        
    }
	public static void main (String[] args) {
		
		int a[]={3, 3, 3, 4, 4, 2};
		int k=3;
		int n=a.length;
		printUnique(a,k,n);
		
	}
}
