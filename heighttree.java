//Height/epth of Binary Tree
import java.util.LinkedList;
import java.util.Queue;

public class heighttree {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
    
    }
    //recursive solution

    public static int height (node root){
        if (root ==null){
            return 0;
        }
        int lh = height(root.left);
        int rh= height(root.right);
        return 1+Math.max(lh,rh);
    }
    //iterative sol level order solution
    public static int heightlevel(node root){
        if(root == null) return 0;
        Queue<node> q= new LinkedList<>();
        q.offer(root);
        int depth=0;
        while(!q.isEmpty()){
            int levelsize= q.size();
            for(int i =0;i<levelsize;i++){
                node temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            depth++;
        }
        return depth;
    }
}
