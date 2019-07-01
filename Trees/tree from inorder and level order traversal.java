class GfG
{   
    Node tree(int in[],int level[],int s,int e){
        
        if(s>e)
        return null;
        
        if(s==e)
        return new Node(in[s]);
        else{
            
            int index=0;
            boolean b=true;
            for(int i=0;i<=level.length-1;i++){
                
                int data=level[i];
                
                for(int j=s;j<=e;j++){
                    
                    if(in[j]==data){
                        b=false;
                        index=j;
                        break;
                    }
                }
                
                if(b==false)
                break;
            }
            
            Node p=new Node(in[index]);
            p.left=tree(in,level,s,index-1);
            p.right=tree(in,level,index+1,e);
            
            return p;
            
        }
        
    }
    
    Node buildTree(int inord[], int level[])
    {
       
        return tree(inord,level,0,level.length-1);
    }
    
   
}
