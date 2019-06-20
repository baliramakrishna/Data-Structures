class LRUCache {
 
    /*Inititalize an LRU cache with size N */
    int n,ln;
    HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
    ArrayList<Integer> l=new ArrayList<Integer>();
    public LRUCache(int N) {
       //Your code here
        n=N;
        ln=0;
    }
 
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       //Your code here
       Integer xx=new Integer(x);
        if(!hm.containsKey(xx))
            return -1;
        l.remove(new Integer(x));
        l.add(x);
       return hm.get(xx);
    }
 
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
       //Your code here
        if(!hm.containsKey(new Integer(x)))
        {
            if(ln==n)
            {
                hm.remove(l.get(0));
                l.remove(new Integer(l.get(0)));
            }
            else
                ln++;
        }
        else
        {
            l.remove(new Integer(x));
            hm.remove(x);
        }
        l.add(x);
        hm.put(x,y);
 
    }
}
