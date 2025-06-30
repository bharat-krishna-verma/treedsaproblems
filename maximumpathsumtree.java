//Maximum path Sum
public class maximumpathsumtree {
   public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     } 
     public static int maxpath(node root){
        int[] maxi= new int[1];
        maxi[0]= Integer.MIN_VALUE;
        height(root, maxi);
        return maxi[0];
     } 
     public static int height(node root,int[] maxi){
        if(root==null) return 0;
        int lh = Math.max(0,height(root.left, maxi));
        int rh = Math.max(0,height(root.right, maxi));
        maxi[0]= Math.max(maxi[0],lh+rh+root.data);
        return Math.max(lh,rh)+root.data;
     }
}
