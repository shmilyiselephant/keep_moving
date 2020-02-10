package string;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import sun.text.normalizer.Trie;

/**
 * @author shmilyiselephant
 * @date 08.02.20
 * @decription
 */
public class MyTrie {
    private TrieNode root = new TrieNode('/');

    public void insert(char[] text) {
        TrieNode p = root;
        for (int i = 0; i < text.length; ++i) {
            int index = text[i] - 'a';
            if (p.children[index] == null) {
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern) {
        TrieNode p = root;
        for (int i = 0; i < pattern.length; ++i) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null)
                return false;
            p = p.children[index];
        }
        return p.isEndingChar;
    }

    static class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;
        public TrieNode(char data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MyTrie aTrie = new MyTrie();
        String[] words = {"he", "hello", "she", "hence", "shame", "super"};
        String[] tests = {"hen", "sha", "shame", "he"};
        for (String word: words) {
            aTrie.insert(word.toCharArray());
        }
        for (String test: tests) {
            System.out.print(test + ":" + aTrie.find(test.toCharArray())+ ", ");
        }

        String s= "-41";
        int i = Integer.parseInt(s);
        System.out.print(i);
    }
}
