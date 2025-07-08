
//leetcode 297
public class serialize_deserialize {

    static class node{
        int data;
        node left;
        node right;
        public node(int val){
            this.data= val;
            this.left= this.right= null;
        }
    }

    private int idx=0;
    public void fn1(node root,StringBuilder sb){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.data+",");
        fn1(root.left,sb);
        fn1(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(node root) {
        StringBuilder sb = new StringBuilder();
        fn1(root,sb);
        return sb.toString();
    }
    
    public node fn2(String[] str){
        if(idx>=str.length||str[idx].equals("null")){
            idx++;
            return null;
        }
        node node = new node(Integer.parseInt(str[idx++]));
        node.left = fn2(str);
        node.right = fn2(str);
        return node;
    }

    // Decodes your encoded data to tree.
    public node deserialize(String data) {
        String[] arr=data.split(",");
        idx=0;
       return fn2(arr);
    }
}
