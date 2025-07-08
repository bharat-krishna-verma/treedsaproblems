//leetcode 222
public class count_complete_tree_nodes {
    // we will use a property of complet binary tree if height = n then number of nodes = 2^n-1
    static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left= this.right= null;
        }
    }
    public static int getLeftHeight(node root){
        node temp = root;
        int lh =0;
        while(temp!=null){
            temp=temp.left;
            lh++;
        }
        return lh;
    }
    public static int getRightHeight(node root){
        node temp = root;
        int rh =0;
        while(temp!=null){
            temp=temp.right;
            rh++;
        }
        return rh;
    }
    public static int count(node root){
        if(root==null) return 0;
        int lh= getLeftHeight(root);
        int rh= getRightHeight(root);
        if(lh==rh) return (int)Math.pow(2,lh)-1;
        return count(root.left)+count(root.right)+1;
    }
}