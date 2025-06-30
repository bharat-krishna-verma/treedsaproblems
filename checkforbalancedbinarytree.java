//Check Balanced Binary Tree
public class checkforbalancedbinarytree {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
    public int height(node root){
        if(root==null) return 0;
        int lh = height(root.left);
        if(lh==-1) return -1;
        int rh = height(root.right);
        if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }
    public boolean isBalanced(node root) {
        int ans = height(root);
        if(ans==-1) return false;
        return true;
    }
}
