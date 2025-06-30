//Check Symmetric Binay Tree
public class checksymmetrictree {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
     public boolean issymmetric(node root){
        return root==null||(issymmetrichelper(root.left, root.right));
     }
     public boolean issymmetrichelper(node left,node right){
            if(left==null&&right==null) return true;    
            if(left==null&&right==null) return false;
            if(left.data!=right.data) return false;
            return issymmetrichelper(left.left, right.right)&&issymmetrichelper(left.right,right.left);
     }
}
