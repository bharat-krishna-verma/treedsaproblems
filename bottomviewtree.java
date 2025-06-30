//Bottom View of Binary Tree
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class bottomviewtree {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
     public class pair{
        int x;
        node node ;
        public pair(node node , int x){
            this.node = node;
            this.x= x;

        }
     }
     public List<Integer> sol(node root){
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>(); 
        q.offer(new pair(root,0));
        while(!q.isEmpty()){
            pair curr= q.poll();
            int x= curr.x;
            node temp = curr.node;
            map.put(x,temp.data);
            
            if(temp.left!=null) {
                q.offer(new pair(temp.left,x-1));
            }
            if(temp.right!=null) {
                q.offer(new pair(temp.right,x+1));
            }
        }
            for(Map.Entry<Integer,Integer> entry: map.entrySet()){
                ans.add(entry.getValue());
            }
        return ans;
     }
}
