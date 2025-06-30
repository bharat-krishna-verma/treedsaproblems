//Binary Tree Diameter
public class diameterinbinarytree {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
     public static int diameterfind(node root){
        int [] diameter= new int [1];
        diameter[0]=0;
        height(root,diameter);
        return diameter[0];
     }
     public static int height(node root,int[] diamaeter){
        if(root==null) return 0;
        int lh=height(root.left, diamaeter);
        int rh=height(root.right, diamaeter);
        diamaeter[0]=Math.max(diamaeter[0],lh+rh);
        return 1+ Math.max(lh,rh);
     }
}
