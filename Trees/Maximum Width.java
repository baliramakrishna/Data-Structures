import java.util.HashMap;

class Node{
	
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
	}
}
public class MaxWidth {

	Node root;

	int maxwidth1(Node root) {
		
		if(root==null)
			return 0;
		HashMap<Integer,Integer> h=new HashMap<>();
		width1(root,h,1);
		
		int mw=0,k;
		for(int i:h.keySet()) {
			k=h.get(i);
			if(k>mw)
				mw=k;
		
			
		}
		
		return mw;
	}
	
	void width1(Node root,HashMap<Integer,Integer> h,int l) {
		
		if(root==null)
			return;
		
		if(h.containsKey(l))
			h.put(l,h.get(l)+1);
		else
			h.put(l,1);
		
		width1(root.left,h,l+1);
		width1(root.right,h,l+1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MaxWidth t=new MaxWidth();
		t.root=new Node(1);
		t.root.left=new Node(2);
		t.root.right=new Node(3);
		t.root.right.right=new Node(4);
		t.root.right.right.right=new Node(7);
		t.root.left.right=new Node(4);
	    t.root.left.right.right=new Node(5);
   		t.root.left.right.right.right=new Node(6);
		System.out.println(t.maxwidth1(t.root));
	}

}
