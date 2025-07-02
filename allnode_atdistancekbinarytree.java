
//Leetcode 863
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class allnode_atdistancekbinarytree {
    static class node {
        int data;
        node left;
        node right;

        public node(int val) {
            this.data = val;
            this.left = this.right = null;
        }
    }

    public static void inorder(HashMap<node, node> map, node root) {
        if (root == null)
            return;
        if (root.left != null)
            map.put(root.left, root);
        inorder(map, root.left);
        if (root.right != null)
            map.put(root.right, root);
        inorder(map, root.right);
    }

    public static List<Integer> bfs(node target, HashMap<node, node> map, int k, List<Integer> ans) {
        Queue<node> q = new LinkedList<>();
        q.offer(target);
        int level = 0;
        while (!q.isEmpty() && level < k) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                node curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                if (map.get(curr) != null)
                    q.offer(map.get(curr));
            }
            level += 1;
        }
        while (!q.isEmpty())
            ans.add(q.poll().data);
        return ans;
    }
    public static List<Integer> sol(node root, node target, int k) {
        HashMap<node, node> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        inorder(map, root);
        return ans;
    }
}
