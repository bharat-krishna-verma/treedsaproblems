// Vertical order Traversal Binary Tree
import java.util.*;
public class verticalordertraversal {
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
        node node;
        int y;
        int x;
        public pair(node node,int x,int y){
            this.x=x;
            this.y=y;
            this.node=node;
        }
     }
     public static List<Integer> sol(node root){
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Queue<pair> q = new LinkedList<>();
        Map<Integer,Map<Integer,PriorityQueue<Integer>>> ds= new TreeMap<>();
        q.offer(new pair(root,0,0));
        while(!q.isEmpty()){
            pair temp = q.poll();
            node curr= temp.node;
            int x= temp.x;
            int y= temp.y;
            if(!ds.containsKey(x)){
                ds.put(x,new TreeMap<>());
            }
            if(!ds.get(x).containsKey(y)){
                ds.get(x).put(y,new PriorityQueue<>());
            }
            ds.get(x).get(y).offer(curr.data);
            if(curr.left!=null) q.offer(new pair(curr.left,x-1,y+1));
            if(curr.right!=null) q.offer(new pair(curr.right,x+1,y+1));
        }
        for(Map<Integer,PriorityQueue<Integer>> levelMap: ds.values()){
            for(PriorityQueue<Integer> pq: levelMap.values()){
                while(!pq.isEmpty()){
                    ans.add(pq.poll());
                }
            }
        }
        return ans;
     }
}
