//leetcode 2385

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class burn_tree {
    static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left= this.right= null;
        }
    }
    //making Adjacency List
    public static void makeGraph(node root,HashMap<Integer,ArrayList<Integer>> map,int parent){
        if(root==null) return ;
        int curr = root.data;
        if(parent !=-1){
            if(!map.containsKey(curr)){
                map.put(curr,new ArrayList<>());
            }
            map.get(curr).add(parent);
            if(!map.containsKey(parent)){
                map.put(parent,new ArrayList<>());
            }
            map.get(parent).add(curr);
        }
        makeGraph(root.left, map,curr);
        makeGraph(root.right, map,curr);
    }
    public static int bfs(HashMap<Integer,ArrayList<Integer>> map,int start){
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visited= new HashSet<>();
        q.offer(start);
        visited.add(start);
        int minutes=0;
        while(!q.isEmpty()){
            int n =q.size();
            for(int i =0;i<n;i++){
                int curr = q.poll();
                if(map.containsKey(curr)){
                    for(int ngbr : map.get(curr)){
                        if(!visited.contains(ngbr)){
                            q.offer(ngbr);
                            visited.add(ngbr);
                        }
                    }
                 }
            }
        minutes++;
        }
        return minutes-1;
    }
    public static int sol(node root,int start){
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        makeGraph(root, map,-1);
        int ans=bfs(map, start);
        return ans;
    }
}
