//Boundry Traversal Binary Tree
import java.util.ArrayList;
import java.util.List;

public class boundrytraversal {
     public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
     }
     public void addLeftBoundry(node root, List<Integer> ans){
        node curr = root;
        while(curr!=null){
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left!=null) curr= curr.left;
            else curr= curr.right;
        }
     }
     public void addRightBoundry(node root, List<Integer> ans){
        List<Integer> temp= new ArrayList<>();
        node curr = root;
        while(curr!=null){
             if(!isLeaf(curr)) temp.add(curr.data);
             if(curr.right!=null) curr= curr.right;
            else curr= curr.left;
        }
        for(int i= temp.size()-1;i>=0;i-- ){
            ans.add(temp.get(i));
        }
     }
     public void addLeaves(node root, List<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null) addLeaves(root.left, ans);
        if(root.right!=null) addLeaves(root.right, ans);
     }
     public boolean isLeaf(node root){
        if(root.left==null&&root.right==null) return true;
        return false;
     }
     public List<Integer>sol(node root){
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        if(!isLeaf(root)) ans.add(root.data);
        addLeftBoundry(root, ans);
        addLeaves(root, ans);
        addRightBoundry(root,ans);
        return ans;
     }
} 
