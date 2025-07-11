//leetcode 106

import java.util.HashMap;

public class construct_binary_tree_from_inorder_postorder {
    static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val; 
            this.left= this.right= null;
        }
    }
    public static node helper(int[] postorder,int[] inorder,HashMap<Integer,Integer> map ,
    int postStart,int postEnd,int inStart,int inEnd){
        if(postStart>postEnd||inStart>inEnd) return null;
        node root = new node(postorder[postEnd]);
        int inRoot= map.get(root.data);
        int inLeft=inRoot-inStart;
        root.left=helper(postorder, inorder, map, postStart, postStart+inLeft-1, inStart, inRoot-1);
        root.right=helper(postorder, inorder, map,postStart+inLeft,postEnd-1,inRoot+1,inEnd);
        return root;
    }
    public static node sol(int[] postorder,int[] inorder){
        HashMap<Integer,Integer> map = new HashMap<>();
        int n = postorder.length-1;
        for(int i=0;i<inorder.length;i++) map.put(inorder[i],i);
        return helper(postorder, inorder, map,0,n,0,n);
    }
}
