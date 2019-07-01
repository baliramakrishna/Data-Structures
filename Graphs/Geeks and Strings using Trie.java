/*
Geek recently read about strings, and he got interested in them.Geek has a list containing N words (not necessarily distinct)-denoted by Li.Now, he will ask Q queries.Each query will consist of a string x.You need to tell How many strings in the List has the string x as its prefix.

Input:
The First line contains an integer T, the number oftestcases.The first line of eachtestcase contains an integer N , the total number of Words.Each of the next N lines contains a string consisting of only lowercase alphabets -denoting Li.
The next Line contains Q- denoting the number of queries.Each of the next Q linescontain a string -denoting the string x. 


Output:
For each query Output an integer denoting the total number of strings in the list that have string x as their prefix.

Constraints:
1<=T<=10
1<= N<=30000
1<=Q<=10000
1<=Li,x<=100

Example:
Input:
1
5
abracadabra
geeksforgeeks
abracadabra
geeks
geeksthrill
5
abr
geeks
geeksforgeeks
ge
gar

Output:
2
3
1
3
0

Explanation:

There are 2 strings that have prefix "abr" - "abracadabra" and "abracadabra"
There are 3 strings that have prefix "geeks" - "geeksforgeeks" and "geeks" and "geeksthrill"
There is 1 string thathave prefix "geeksforgeeks" - "geeksforgeeks".
There are 3 strings that have prefix "ge" - "geeksforgeeks" and "geeks" and "geeksthrill"
There is No string thathave prefix as "gar".  */










import java.util.*;
import java.lang.*;
import java.io.*;
class Graph
 {   
     Trie root;
     static class Trie{
         
         HashMap<Character,Trie> child=new HashMap<>();
         boolean isEnd=false;
         int count=0;
     }
     
     Graph(){
         root=new Trie();
     }
     
     void insert(String str){
         
         int n=str.length();
         Trie p=root;
         
         for(int i=0;i<n;i++){
             
             char ch=str.charAt(i);
             Trie node=p.child.get(ch);
             
             if(node==null){
                 node=new Trie();
                 p.child.put(ch,node);
                 
             }
             p=node;
             p.count++;
         }
         
         p.isEnd=true;
     }
     
     int prefix(String str){
         
         Trie current=root;
         int n=str.length();
         for(int i=0;i<n;i++){
             char ch=str.charAt(i);
             Trie node=current.child.get(ch);
             
             if(node==null)
             return 0;
             
             current=node;
         }
         
         return current.count;
         
     }
     
	public static void main (String[] args) throws IOException
	 {
	   
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
  
        while (t-- > 0) { 
          
          Graph g=new Graph();
           int n=Integer.parseInt(br.readLine());
          for(int i=0;i<n;i++)
          g.insert(br.readLine());
          
    
          int q=Integer.parseInt(br.readLine());
          
          while(q-->0)
            System.out.println(g.prefix(br.readLine()));
          
          
          
        
        }
	  
	  
	 }
}






