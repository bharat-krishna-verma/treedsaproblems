//Right Side View Binary Tree
import java.util.ArrayList;
import java.util.List;

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
}
