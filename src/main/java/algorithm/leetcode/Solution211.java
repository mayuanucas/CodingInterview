package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc: 添加与搜索单词 - 数据结构设计
 * @date: 2019/02/14
 */
public class Solution211 {

    TrieNode root = new TrieNode();

    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search(String word) {
        return dfs(root, word.toCharArray(), 0);
    }

    private boolean dfs(TrieNode node, char[] chs, int index) {
        if (index == chs.length) {
            return !node.item.equals("");
        }
        if ('.' != chs[index]) {
            return null != node.children[chs[index] - 'a'] && dfs(node.children[chs[index] - 'a'], chs, index + 1);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (dfs(node.children[i], chs, index + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String item = "";
    }

}
