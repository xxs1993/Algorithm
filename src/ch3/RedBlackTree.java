package ch3;


import com.sun.deploy.util.BlackList;

public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;
    private class Node{
         Comparable key;
         Comparable value;
         Node left,right;
         boolean color;
         public Node(Comparable key,Comparable value,boolean color){
             this.key = key;
             this.value = value;
             this.color = color;
         }
    }

    private boolean isRed(Node n){
        if(n == null) return false;
        return n.color;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        x.color = h.color;
        h.color = RED;
        h.right = x.left;
        x.left = h;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipToTreeNode(Node h){
       h.color = RED;
       h.left.color = BLACK;
       h.right.color = BLACK;
    }

    public void Node(Comparable key, Comparable val){
        root = put(key,val,root);
    }

    public Node put(Comparable key,Comparable val,Node h){
        if(h == null) return new Node(key,val,RED);
        int compare = key.compareTo(h.key);
        //recursive
        if(compare > 0) h.right = put(key,val,h.right);
        else if(compare < 0)h.left = put(key,val,h.left);
        else h.value = val;
        // 3 cases to solve
        if(isRed(h.right)&&!isRed(h.left))h = rotateLeft(h);
        else if(isRed(h.left)&&isRed(h.left.left)) h = rotateRight(h);
        else if(isRed(h.left)&&isRed(h.right)) flipToTreeNode(h);
        return h;
    }

    public Comparable get(Comparable key){
        Node r = root;
        while (r!=null){
            int cmp = key.compareTo(r.key);
            if(cmp > 0) r = r.right;
            else if(cmp <0) r = r.left;
            else return r.value;
        }
        return null;
    }
}
