{
import java.util.*;
import java.io.*;
import java.lang.*;
class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int nov = sc.nextInt();
            int edg = sc.nextInt();
            for(int i = 0; i < nov+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 1; i <= edg; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if(new DetectCycle().isCyclic(list, nov) == true)
                System.out.println("1");
            else System.out.println("0");
        }
    }
}
}
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
/*
ArrayList<ArrayList<Integer>> list: to represent graph containing 'v'
                                    vertices and edges between them
V: represent number of vertices
*/
class DetectCycle
{
    static boolean isCyclic(ArrayList<ArrayList<Integer>> list, int V)
    {  
        
     
        
        HashSet<Integer> white=new HashSet<>();
        HashSet<Integer> grey=new HashSet<>();
        HashSet<Integer> black=new HashSet<>();
        
        for(int i=0;i<V;i++)
        white.add(i);
        
        while(white.size()!=0){
            
             int x=white.iterator().next();
            if(dfs(list,x,white,grey,black))
            return true;
            
        }
        
        return false;
    }
   
    
    static boolean dfs(ArrayList<ArrayList<Integer>> list,int x,HashSet<Integer> white, HashSet<Integer> grey,HashSet<Integer> black){
        
        
        white.remove(x);
        grey.add(x);
        
        for(int p:list.get(x)){
            
                
                
                
                if(black.contains(p))
                continue;
                
                if(grey.contains(p))
                return true;
                
                if(dfs(list,p,white,grey,black))
                return true;
                

            
        }
        
        grey.remove(x);
        black.add(x);
        return false;
        
    }
}
