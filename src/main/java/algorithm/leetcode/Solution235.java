package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 二叉搜索树的最近公共祖先
 * @date: 2018/12/01
 */
public class Solution235 {

    /**
     * 二叉搜索树的特点:
     * 1.若左子树不空，则左子树上所有结点的值均小于它的根结点的值；
     * 2.若右子树不空，则右子树上所有结点的值均大于它的根结点的值；
     * 3.左、右子树也分别为二叉排序树；
     * 4.没有键值相等的结点。
     * <p>
     * 根据目标节点的值和根节点的值来判断目标节点在跟节点的左子树上还是右子树上，
     * 如果一个在左一个在右，就说明其LCA是根节点；如果都在左或者都在右，
     * 就对跟节点的左或者右子节点调用同样的方法进行递归。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || null == p || null == q) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, q, p);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
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
