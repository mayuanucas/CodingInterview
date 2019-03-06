package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 从中序与后序遍历序列构造二叉树
 * @date: 2019/03/06
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return dfs(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    private TreeNode dfs(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd || postEnd < 0) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postEnd]);
        int inIndex = 0;
        for (int i = inEnd; i >= inStart; --i) {
            if (inorder[i] == node.val) {
                inIndex = i;
                break;
            }
        }

        node.left = dfs(inorder, postorder, inStart, inIndex - 1, postEnd - (inEnd - inIndex + 1));
        node.right = dfs(inorder, postorder, inIndex + 1, inEnd, postEnd - 1);
        return node;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
