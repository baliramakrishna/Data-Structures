class GFG
{ 
    static int res=-1;
    public static int printkdistanceNode(Node root, Node target , int k)
    { 
        res=-1;
        get(root,target,0);
        
        if(res==-1)
        return -1;
        
        Node nul=null;
        HashMap<Node,Node> h=new HashMap<>();
        HashSet<Node> h1=new HashSet<>();
        
        h.put(root,nul);
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            
            Node temp=q.poll();
            
            if(temp.left!=null){
            h.put(temp.left,temp);
            q.add(temp.left);
            }
            if(temp.right!=null){
                h.put(temp.right,temp);
                q.add(temp.right);
            }
        }
        
        int level=0;
        q.add(target);
        q.add(nul);
        h1.add(target);
        while(!q.isEmpty() && level<k){
            
            
            
            boolean b= true;
            while(!q.isEmpty() && q.peek()!=nul){
                
                Node temp=q.poll();
                Node parent=h.get(temp);
                if(temp.left!=null && !h1.contains(temp.left)){
                    h1.add(temp.left);
                    q.add(temp.left);
                    
                    level=b?level+1:level;
                    
                    b=false;
                }
                
                if(temp.right!=null && !h1.contains(temp.right)){
                    h1.add(temp.right);
                    q.add(temp.right);
                   
                   level=b?level+1:level;
                    
                    b=false;
                }
                
                if(parent!=nul && !h1.contains(parent)){
                h1.add(parent);
                q.add(parent);
               
               level=b?level+1:level;
                    
                    b=false;
                }
                
              
            }
            
            q.poll();
            if(!q.isEmpty())
            q.add(nul);
            
            
        }
        
    StringBuffer b=new StringBuffer();
    
    while(q.size()>1)
    b.append(q.poll().data+" ");
    
    System.out.print(b);
    
      return res;
        
    }
    
    static void get(Node root,Node target,int l){
        
        if(root==null)
        return;
        
        else if(target==root){
            res=l;
            return;
        }
        else{
            
            get(root.left,target,l+1);
            get(root.right,target,l+1);
        }
    }
   
}
