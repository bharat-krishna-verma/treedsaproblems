//Binary Tree Post order iterative traversal
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postorderiterativetree {
    public class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
    }
    public List<Integer> iterative_traversal_postorder(node root){
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        Stack<node> st1= new Stack<>();
        Stack<node> st2= new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()){
            root= st1.pop();
            st2.push(root);
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);
        }
        while(!st2.isEmpty()){
            ans.add(st2.pop().data);
        }
         return ans;
    }
}
