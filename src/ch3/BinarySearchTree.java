package ch3;


import sun.misc.Queue;

public class BinarySearchTree {
    private class Node{
        Comparable key;
        Comparable value;
        Node left,right;
        int count;
        public Node(Comparable key,Comparable value,int count){
            this.key = key;
            this.value = value;
            this.count = count;
        }

    }

    private int size(Node x){
        if(x == null) return 0;
        return x.count;
    }

    private Node root;

    private Node put(Comparable key,Comparable value,Node node){
        if(node == null) return new Node(key,value,1);
        int cmp = key.compareTo(node.key);
        if(cmp >0 )node.right = put(key,value,node.right);
        else if(cmp < 0 )node.left = put(key,value,node.left);
        else node.value = value;
        node.count  = size(node.left) + size(node.right)+1;
        return node;
    }

    public Node floor(Comparable key){
        return floor(key,root);
    }
    private Node floor(Comparable key,Node node){
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node;
        else if(cmp < 0) return floor(key,node.left);
            Node t =floor(key,node.right);
            if(t !=null){
                return t;
            }else {
                return node;

            }
    }

    private int rank(Comparable key,Node node){
        if(node == null) return 0;
        int cmp = key.compareTo(node.key);
        if(cmp <0) return rank(key,node.left);
        else if(cmp == 0) return size(node.left);
        else return 1+rank(key,node.right) +size(node.left);
    }

    private void inOrder(Node x , Queue<Node> queue){
        if(x == null ) return;
        inOrder(x.left,queue);
        queue.enqueue(x);
        inOrder(x.right,queue);
    }

    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = size(x.left) +size(x.right) +1;
        return x;
    }
    private Node min(Node x){
        if(x == null) return null;
        while (x.left!=null)x = x.left;
        return x;
    }

    private Node delete(Comparable key,Node x){
        if(x==null)return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) x.left = delete(key,x.left);
        else if(cmp >0) x.right = delete(key,x.right);
        else {
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.count = size(x.left) + size(x.right) +1;
        return x;
    }
}
