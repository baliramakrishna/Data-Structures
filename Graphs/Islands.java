class Islands
{
    static int row[]={1,1,1,-1,-1,-1,0,0};
    static int coloumn[]={-1,0,1,-1,0,1,-1,1};
    
    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M)
    {
      boolean visited[][]=new boolean[N][M];
      int count=0;
      for(int i=0;i<N;i++){
          ArrayList<Integer> l=list.get(i);
          for(int j=0;j<M;j++){
              
              if(l.get(j)==1 && visited[i][j]==false){
              dfs(list,i,j,N,M,visited);
              count++;
              }
          }
      }
      
     return count;   
    }
    
    static boolean isValid(ArrayList<ArrayList<Integer>> list,int  i,int j,int N,int M){
        
        if(i>=0 && j>=0 && i<N && j<M && (list.get(i)).get(j)==1)
        return true;
        else
        return false;
        
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> list,int i,int j,int N,int M,boolean visited[][]){
        
        visited[i][j]=true;
        for(int v=0;v<8;v++){
            
            int r=i+row[v];
            int c=j+coloumn[v];
            
            if( isValid(list,r,c,N,M) && visited[r][c]!=true )
            dfs(list,r,c,N,M,visited);
        }
        
    }
    
}
