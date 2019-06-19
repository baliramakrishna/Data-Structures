{
import java.util.*;
class Rat{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[][] a=new int[n][n];
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					a[i][j]=sc.nextInt();
			GfG g=new GfG();
			ArrayList<String> res=g.printPath(a,n);
			for(int i=0;i<res.size();i++)
				System.out.print(res.get(i)+" ");
			System.out.println();
		}
	}
}
}
/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
class GfG{
    
    static int row[]={1,-1,0,0};
    static int coloumn[]={0,0,1,-1};
    static char ch[]={'D','U','R','L'};
     public static ArrayList<String> printPath(int[][] m, int n)
     {
           
           ArrayList<String> l=new ArrayList<>();
           
           boolean visited[][]=new boolean[n][n];
           dfs(m,n,visited,0,0,"",l);
           
           Collections.sort(l);
           return l;
     }
     
     
     static void dfs(int m[][],int n,boolean visited[][],int i,int j,String str,ArrayList<String> l){
        
         visited[i][j]=true;
         
         if(i==n-1 && j==n-1){
             
             l.add(str);
             visited[i][j]=false;
             return;
         }
          
         for(int v=0;v<4;v++){
             
             int r=i+row[v];
             int c=j+coloumn[v];
             char p=ch[v];
             
             if(r>=0 && c>=0 && r<n && c<n && m[r][c]==1 && visited[r][c]==false){
    
                 dfs(m,n,visited,r,c,str+p,l);
               
             }
             
         }
         
         visited[i][j]=false;
     }
     
     
}
