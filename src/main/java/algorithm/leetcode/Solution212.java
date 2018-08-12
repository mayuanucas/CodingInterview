package algorithm.leetcode;

import java.util.*;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/12
 */
public class Solution212 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};

        char[][] board2 = new char[][]{{'a', 'a'}};

        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        String[] words2 = new String[]{"a"};

        Solution212 test = new Solution212();
        List<String> ans = test.findWords(board, words);
//        List<String> ans = test.findWords(board2, words2);
        ans.forEach(item -> System.out.println(item));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>(words.length);
        // 构建前缀树
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfs(board, root, result, i, j);
            }
        }

        Collections.sort(result);
        return result;
    }

    private void dfs(char[][] board, TrieNode p, List<String> answer, int x, int y) {
        char c = board[x][y];
        if ('#' == c || null == p.children[c - 'a']) {
            return;
        }

        p = p.children[c - 'a'];
        if (null != p.word) {
            if (!answer.contains(p.word)) {
                answer.add(p.word);
            }
        }

        board[x][y] = '#';
        if (x > 0) {
            dfs(board, p, answer, x - 1, y);
        }
        if (y > 0) {
            dfs(board, p, answer, x, y - 1);
        }
        if (x < board.length - 1) {
            dfs(board, p, answer, x + 1, y);
        }
        if (y < board[x].length - 1) {
            dfs(board, p, answer, x, y + 1);
        }
        board[x][y] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode cur = root;
            for (char letter : word.toCharArray()) {
                int index = letter - 'a';

                if (null == cur.children[index]) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word = word;
        }

        return root;
    }
}

class TrieNode {
    TrieNode[] children;
    String word;

    public TrieNode() {
        children = new TrieNode[26];
    }
}
