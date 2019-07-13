/*
Given a list of contacts which exist in a phone directory and a query string str. The task is to implement search query for the phone directory. Run a search query for each prefix p of the query string str(i.e from  index 1 to str length) that prints all the distinct recommended contacts which have the same prefix as our query (p) in lexicographical order. Please refer the explanation part for better understanding.

NOTE: If there is no match between query and contacts , print "0".

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains three lines. First line of each test case contains N i.e., number of contacts. Second line contains space separated all the contacts in the form of string. And third line contains query string.

Output
For each test case, print each query result in new line. If there is no match between query and contacts, print "0".

Constraints:
1<=T<=100
1<=N<=50
1<=|contact[i].length|<=50
1<=|query length|<=6

Example:
Input:
1
3
geeikistest geeksforgeeks geeksfortest
geeips

Output:

geeikistest geeksforgeeks geeksfortest 
geeikistest geeksforgeeks geeksfortest
geeikistest geeksforgeeks geeksfortest
geeikistest
0
0
Explanation:

By running the query on contact list, we get, 
Suggestions based on "g" are: 
geeikistest geeksforgeeks geeksfortest 
Suggestions based on "ge" are:
geeikistest geeksforgeeks geeksfortest
Suggestions based on "gee" are:
geeikistest geeksforgeeks geeksfortest
Suggestions based on "geei" are:
geeikistest
No Results Found for "geeip", So print "0".
No Results Found for "geeips", So print "0".    
*/



import java.util.*;
import java.lang.*;
import java.io.*;
class Graph
 {  
     Trie root;
     
     class Trie{
         
       TreeMap<Character,Trie> child=new TreeMap<>();
         boolean isEnd;
         
     }
     
     Graph(){
         root=new Trie();
     }
     
     void insert(String str){
         
         Trie current=root;
         
         int n=str.length();
         for(int i=0;i<n;i++){
             
             char ch=str.charAt(i);
             Trie node=current.child.get(ch);
             if(node==null){
                 node=new Trie();
                 current.child.put(ch,node);
             }
             current=node;
         }
         current.isEnd=true;
         
     }
     
     void print(String str,Trie current){
         
         
         if(current.isEnd)
         System.out.print(str+" ");
         
         for(char ch:current.child.keySet())
         print(str+ch,current.child.get(ch));
         
         
     }
     void print(String str){
         
         Trie current=root;
         int n=str.length();
         String res="";
         boolean empty=false;
         for(int i=0;i<n;i++){
             
            char ch=str.charAt(i);
            if(empty)
            System.out.println(0);
            else{
                
            Trie node=current.child.get(ch);
            if(node==null){
            System.out.println(0);
            empty=true;
            }
            else{
                
                res=res+ch;
                print(res,node);
                System.out.println();

            }
            current=node;
           }
         }
         
     }
	public static void main (String[] args) throws IOException
	 {
	   
	   Scanner s=new Scanner(System.in);
	   int t=s.nextInt();
  
        while (t-- > 0) { 
          
           int n=s.nextInt();
           String str[]=new String[n];
            Graph g=new Graph();
           for(int i=0;i<n;i++){
           str[i]=s.next();
           g.insert(str[i]);
           }
          
           String pat=s.next();
           
           g.print(pat);
           
        }
	  
	  
	 }
}


