class TrieNode {//O(1) Time & Space

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch -'a'] != null;
    }
    public TrieNode get(char ch) {
        return links[ch -'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch -'a'] = node;
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}
class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();//O(1) Space and Time
    }

    // Inserts a word into the trie.
    public void insert(String word) {// Time: O(m), Space: O(m)->worst case m is the length of the word
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }
      private TrieNode searchPrefix(String word) {// Time: O(m), Space: O(1)->worst case m is the length of the word
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
           char curLetter = word.charAt(i);
           if (node.containsKey(curLetter)) {
               node = node.get(curLetter);
           } else {
               return null;
           }
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {// Time: O(m), Space: O(1)->worst case m is the length of the word
       TrieNode node = searchPrefix(word);
       return node != null && node.isEnd();
    }
        public boolean startsWith(String prefix) {// Time: O(m), Space: O(1)->worst case m is the length of the word
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}//the whole code takes O(4m)->O(m)Time & Space ^-^