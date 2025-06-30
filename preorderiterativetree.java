// Pre Order Traversal Iterative
import java.util.*;
public class preorderiterativetree {
    public class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
    }
    public List<Integer> iterative_traversal_preorder(node root){
        List<Integer> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        Stack<node> st= new Stack<>();
        st.push(root);
        while(!st.empty()){
            root = st.pop();
            ans.add(root.data);
            if(root.right!=null){
                st.push(root.right);

            }
            if(root.left!=null){
                st.push(root.left);

            }
        }
        return ans;
    }
}
