package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 将有序数组转换为二叉搜索树
 * @date: 2019/03/07
 */
public class Solution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums || 0 >= nums.length) {
            return null;
        }

        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        int mid = (start + end) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, start, mid - 1);
        node.right = dfs(nums, mid + 1, end);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
