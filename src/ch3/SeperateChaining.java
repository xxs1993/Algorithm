package ch3;

public class SeperateChaining {
    private Node[] array;
    private  int M = 97;
    private class Node{
        Object key;
        Object value;
        Node next;
        public Node(Object k,Object v,Node next){
            this.key = k;
            this.value = v;
            this.next  = next;
        }
    }

    public int hash(Object key){
        return (key.hashCode()&0x7fffffff)%M;
    }

    public Node get(Object key){
        int hash = hash(key);
        Node x = array[hash];
        while (x!=null){
            if(x.key.equals(key))
                return x;
            x = x.next;
        }
        return null;
    }

    public void put(Object key,Object value){
        int hash = hash(key);
        for(Node x = array[hash]; x.next!=null;x=x.next ){
            if(key.equals(x.key))x.value =value;return;
        }
         array[hash] = new Node(key,value,array[hash]);

    }
}
