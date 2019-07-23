{
import java.util.*;
class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{c
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			GfG g = new GfG();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
}
/*This is a function problem.You only need to complete the function given below*/
/*You are required to complete this method */
class GfG
{  
    boolean find(int a[],HashSet<Integer> h,int n,int res,int k,int sum){
        
        int m=h.size();
        
        if(res==sum)
        k--;
        else if(sum>res)
        return false;
        
       if(m==n){
           
           if(k==0 && sum==res)
           return true;
           else
           return false;
       }
        
        if(res==sum)
        sum=0;
        
        for(int i=0;i<n;i++){
            
            if(h.contains(i))
            continue;
            else{
                h.add(i);
                if(find(a,h,n,res,k,sum+a[i]))
                return true;
                else
                h.remove(i);
            }
        }
        
        return false;
        
        
    }
    
    boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here
	 
	 if(k==1)
	 return true;
	 else if(k>n)
	 return false;
	 int sum=0;
	 for(int i=0;i<n;i++)
	 sum+=a[i];
	 
	 if(sum%k!=0)
	 return false;
	 
	 int res=sum/k;
	 HashSet<Integer> h=new HashSet<>();
	 
	 return find(a,h,n,res,k,0);
    }
}
