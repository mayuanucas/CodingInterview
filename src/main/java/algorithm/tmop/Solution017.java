package algorithm.tmop;

/**
 * @author: mayuan
 * @desc: 二叉树的最近公共祖先
 * @date: 2018/12/02
 */
public class Solution017 {

    /**
     * 在root为根的二叉树中找A,B的LCA:
     * 如果找到了就返回这个LCA
     * 如果只碰到A，就返回A
     * 如果只碰到B，就返回B
     * 如果都没有，就返回null
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p == root || q == root) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (null != left && null != right) {
            return root;
        }

        return null != left ? left : right;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
