// Zig Zag Traversal Binary Tree
import java.util.*;
public class zigzagtraversal {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     } 
     public static List<List<Integer>> traversal(node root){
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<node> q = new LinkedList<>();
        q.offer(root);
        boolean flag=true;
        while(!q.isEmpty()){
            int levelsize= q.size();
            List<Integer> level = new LinkedList<>();
            for(int i =0;i<levelsize;i++){
                node temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
                // int index=(flag) ?i:(levelsize-1-i);
                if(flag){
                    level.addLast(temp.data);
                }
                else{
                    level.addFirst(temp.data);
                }
            }
            flag=!flag;
            ans.add(level);
        }
        return ans;
     }
}