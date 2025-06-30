//Root to Node path Binary Tree
import java.util.ArrayList;
import java.util.List;
public class roottonodepath {
    public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
     public boolean helper(node root ,int n ,  List<Integer> ans){
        if(root ==null ) return false;
        ans.add(root.data);
        if(root.data==n) return true;
        if(helper(root.left, n, ans)||helper(root.right, n, ans)){
            return true;
        }
        ans.remove(ans.size()-1);
        return false;
     }
     public List<Integer> sol(node root,int n){
        List<Integer> ans = new ArrayList<>();
        helper(root, n, ans);
        return ans;
     }
}
