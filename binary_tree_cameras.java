//leetcode 968

import java.util.*;
public class binary_tree_cameras {
    static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left= this.right= null;
        }
    }
    // public void inorder(HashMap<node ,node> map,node root){
    //     if(root==null) return;
    //     if(root.left!=null) map.put(root.left,root);
    //     inorder(map, root.left);
    //     if(root.right!=null) map.put(root.right,root);
    //     inorder(map, root.right);
    // }
public int sol(node root){
    if(root==null) return 0;
       int count =0;
        // HashMap<node,node> map = new HashMap<>();
        // inorder(map, root);
        return count;
    }
    
}