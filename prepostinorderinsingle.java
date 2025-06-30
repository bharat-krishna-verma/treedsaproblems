//PerPost Order Traversal in single 
import java.util.*;
public class prepostinorderinsingle {
     public static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left=this.right= null;
        }
    }
   public static class Pair{
        node curr;
        int n;
    public Pair(node curr,int n){
        this.curr= curr;
        this.n=n;
    }
    }
    public void preinpost(node root){
         if(root==null) return;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
       
        while(!st.isEmpty()){
            Pair it = st.pop();
            if(it.n==1){
                pre.add(it.curr.data);
                it.n++;
                st.push(it);
                if(it.curr.left!=null){
                    st.push(new Pair(it.curr.left,1));
                }
            }
            else if(it.n==2){
                in.add(it.curr.data);
                it.n++;
                st.push(it);
                if(it.curr.right!=null){
                    st.push(new Pair(it.curr.right,1));
                }
            }
            else{
                post.add(it.curr.data);
            }
        }
    }
}
