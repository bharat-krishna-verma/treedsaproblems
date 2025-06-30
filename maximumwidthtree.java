//Maximum Width of Tree
import java.util.*;
public class maximumwidthtree {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
    }
    public static class pair{
        long idx;
        node node;
        public pair(node node,long idx){
            this.node = node;
            this.idx= idx;
        }
    }
    public static int width(node root){
        Deque<pair> q = new LinkedList<>();
        q.offer(new pair(root,0));
        int maxWidth=0;
        while(!q.isEmpty()){
            long l = q.peekFirst().idx;
          long r=q.peekLast().idx;
            maxWidth=Math.max(maxWidth,(int)(r-l+1));
            int n = q.size();
            for(int i=0;i<n;i++){
                node curr = q.peekFirst().node;
                long idx= q.peekFirst().idx;
                q.poll();
                if(curr.left!= null) q.offer(new pair(curr.left,2*idx+1));
                if(curr.right!= null) q.offer(new pair(curr.right,2*idx+2));

                
            }
           
        }
         return maxWidth;

}
}