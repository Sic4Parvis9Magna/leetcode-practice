import java.util.ArrayList;
import java.util.List;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie
 * (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * Example 1:
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * 
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple"); // return True
 * trie.search("app"); // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app"); // return True
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and
 * startsWith.
 * 
 * ImplementTrie
 * 
 * STATUS: COMPLETED
 * 
 */
public class ImplementTrie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // return True
        System.out.println(trie.search("app")); // return False
        System.out.println(trie.startsWith("app")); // return True
        trie.insert("app");
        System.out.println(trie.search("app")); // return True
    }
}

class Trie {
    private final Node[] nodes;

    public Trie() {
        nodes = new Node[26];
    }

    public void insert(String word) {
        int startIndex = word.charAt(0) - (int) 'a';
        Node currentNode = nodes[startIndex];
        if (currentNode == null) {
            Node next = new Node(word.charAt(0));
            nodes[startIndex] = next;
            currentNode = next;
        }
        for (int i = 1; i < word.length(); i++) {
            char nextChar = word.charAt(i);
            if (!currentNode.hasChild(nextChar)) {
                Node newNode = new Node(nextChar);
                currentNode.addChild(newNode);
            }
            currentNode = currentNode.getChild(nextChar);
        }
        currentNode.setWordEnd(true);
    }

    public boolean search(String word) {
        int startIndex = word.charAt(0) - (int) 'a';
        Node currentNode = nodes[startIndex];
        if (currentNode == null) {
            return false;
        }

        for (int i = 1; i < word.length(); i++) {
            char nextChar = word.charAt(i);
            if (!currentNode.hasChild(nextChar)) {
                return false;
            }
            currentNode = currentNode.getChild(nextChar);
        }

        return currentNode.isWordEnd();
    }

    public boolean startsWith(String prefix) {
        int startIndex = prefix.charAt(0) - (int) 'a';
        Node currentNode = nodes[startIndex];
        if (currentNode == null) {
            return false;
        }

        for (int i = 1; i < prefix.length(); i++) {
            char nextChar = prefix.charAt(i);
            if (!currentNode.hasChild(nextChar)) {
                return false;
            }
            currentNode = currentNode.getChild(nextChar);
        }

        return true;
    }

    class Node {
        private final char c;
        private boolean wordEnd;
        private final Node[] childs;

        Node(char c) {
            this.c = c;
            this.wordEnd = false;
            this.childs = new Node[26];
        }

        public void addChild(Node child) {
            int index = child.getChar() - (int) 'a';
            if (childs[index] != null) {
                throw new RuntimeException("Cannot add child of the same kind");
            }
            childs[index] = child;
        }

        public boolean hasChild(char c) {
            int index = c - (int) 'a';
            return childs[index] != null;
        }

        public Node getChild(char c) {
            int index = c - (int) 'a';
            return childs[index];
        }

        public char getChar() {
            return this.c;
        }

        public boolean isWordEnd() {
            return this.wordEnd;
        }

        public void setWordEnd(boolean val) {
            this.wordEnd = val;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */