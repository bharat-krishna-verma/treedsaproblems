//leetcode 105

import java.util.HashMap;

public class construct_binary_tree_from_inorder_preorder {
    static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val; 
            this.left= this.right= null;
        }
    }
    public static node helper(int[] preorder,int[] inorder,HashMap<Integer,Integer> map,int preStart,int preEnd,int inStart,int inEnd){
        if(preStart>preEnd||inStart>inEnd) return null;
        node root= new node(preorder[preStart]);
        int inRoot= map.get(root.data);
        int numsLeft=inRoot-inStart;
        root.left=helper(preorder, inorder, map, preStart+1, preStart+numsLeft, inStart, inRoot-1);
        root.right= helper(preorder, inorder, map, preStart+numsLeft+1, preEnd, inRoot+1, inEnd);
        return root;
    }
    public static void maping(int[] inorder,HashMap<Integer,Integer> map){
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
    }
    public static node sol(int[] preorder,int[] inorder){
        HashMap<Integer,Integer> map= new HashMap<>();
        maping(inorder,map);
        return helper(preorder,inorder,map,0,inorder.length-1,0,inorder.length-1);
    }
}
