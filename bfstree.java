//BFS(Level Order) Traversal of Binary Tree
import java.util.*;
public class bfstree {
    static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left= this.right= null;
        }
         
    }
    public static List<List<Integer>> bfs(node root){
        Queue<node> q= new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int level = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i =0;i<level;i++){
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                temp.add(q.poll().data);
            }
            ans.add(temp);
        }
        return ans;
    }
}
