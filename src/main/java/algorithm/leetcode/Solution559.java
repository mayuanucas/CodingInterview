package algorithm.leetcode;

import java.util.List;

/**
 * @author: mayuan
 * @desc: N叉树的最大深度
 * @date: 2019/03/10
 */
public class Solution559 {
    public int maxDepth(Node root) {
        if (null == root) {
            return 0;
        }

        int mx = 0;
        for (Node node : root.children) {
            mx = Math.max(mx, maxDepth(node));
        }
        return mx + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
