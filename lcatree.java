//Lowest Common Ancestor Binary Tree
public class lcatree {
     public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
     public static node lca(node root,node p,node q){
            if(root==null) return null;
            //leftN
            if(root==p||root==q) return root;
            node leftN = lca(root.left, p, q);
            node rightN = lca(root.right, p, q);
            if(leftN!=null&&rightN!=null) return root;
            if(leftN!=null) return leftN;
            return rightN;
     } 
}
