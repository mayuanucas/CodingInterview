package algorithm.leetcode;

/**
 * @author: mayuan
 * @desc:
 * @date: 2018/08/12
 */
public class Trie {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node cur = root;
        for (char letter : word.toCharArray()) {
            if (null == cur.children[letter - 'a']) {
                cur.children[letter - 'a'] = new Node();
            }
            cur = cur.children[letter - 'a'];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node cur = root;
        for (char letter : word.toCharArray()) {
            if (null == cur.children[letter - 'a']) {
                return false;
            }
            cur = cur.children[letter - 'a'];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (char letter : prefix.toCharArray()) {
            if (null == cur.children[letter - 'a']) {
                return false;
            }
            cur = cur.children[letter - 'a'];
        }
        return true;
    }

    class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            children = new Node[26];
            isEnd = false;
        }
    }
}
