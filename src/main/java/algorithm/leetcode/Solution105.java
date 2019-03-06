package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 从前序与中序遍历序列构造二叉树
 * @date: 2019/03/06
 */
public class Solution105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (inStart > inEnd || preStart > preorder.length - 1) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; ++i) {
            if (inorder[i] == node.val) {
                inIndex = i;
                break;
            }
        }

        node.left = dfs(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        node.right = dfs(preorder, inorder, preStart + inIndex - inStart + 1, inIndex + 1, inEnd);
        return node;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
