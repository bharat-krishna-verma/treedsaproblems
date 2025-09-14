//Right Side View Binary Tree
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightsideviewtree {
    //we will use reverse pre order traversal when level is equal to datastructure 
    // ADD element to data structure
        public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
     public static void reversepreorder(node root,int level, List<Integer> ans){
        if(root==null) return ;
        if(level==ans.size()) ans.add(root.data);
        reversepreorder(root.right, level+1, ans);
        reversepreorder(root.left, level+1, ans);
     }
     public static List<Integer> sol(node root){
        List<Integer> ans = new ArrayList<>();
        if(root ==null) return ans;
        reversepreorder(root, 0, ans);
        return ans;
        
     } 
      public List<Integer> rightSideViewusinfBFS(node root) {
         ArrayList<Integer> ans = new ArrayList<>();
         if(root==null) return ans;
         Queue<node> qu = new LinkedList<>();
         qu.offer(root);
         node temp = null;
         while (!qu.isEmpty()) {
            int levelsize= qu.size();
            for(int i =0;i<levelsize;i++){
               temp = qu.poll();
               if(temp.left!=null)qu.offer(temp.left);
               if(temp.right!=null)qu.offer(temp.right);
            }
            ans.add(temp.data);
         }
         return ans;
      }
}
