/*package whatever //do not write package name here */

import java.util.*;

class Graph {
     
     int v;
     LinkedList<Integer> l[];
     
     Graph(int v){
         this.v=v;
         l=new LinkedList[v];
         
         for(int i=0;i<v;i++)
         l[i]=new LinkedList<>();
     }
     
     void addEdge(int x,int y){
         l[x].add(y);
     }
     
     
     void topologicalSort(){
         
        boolean visited[]=new boolean[v];
        
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<v;i++){
            
            if(visited[i]==false)
            sort(i,s,visited);
        }
        
        while(!s.isEmpty()){
            char ch=(char)(s.peek()+'a');
            s.pop();
            System.out.print(ch+" ");
        }
         
     }
     
     void sort(int k,Stack<Integer> s,boolean visited[]){
         
         visited[k]=true;
         
         for(int p:l[k]){
             
             if(visited[p]==false)
             sort(p,s,visited);
         }
         s.push(k);
     }
      void printWords(String words[],int n){
         
         
         for(int i=0;i<n-1;i++){
             
             
             for(int j=0;j<Math.min(words[i].length(),words[i+1].length());j++){
                 
                 if(words[i].charAt(j)!=words[i+1].charAt(j)){
                     
                     addEdge(words[i].charAt(j)-'a',words[i+1].charAt(j)-'a');
                     break;
                 }
             }
         }
         
        topologicalSort();
         
         
         
     }
    
	public static void main (String[] args) {
		
	
		String[] words = {"baa", "abcd", "abca", "cab", "cad"}; 
		Graph g=new Graph(4);
		g.printWords(words,5);
		
		
	}
}
