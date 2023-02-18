/*
Understanding:
    Trie store and retrieve keys
    Questions:
    
Target:

Solution:


*/
class Trie{
    Trie[] children;
    boolean isEnd;
    public Trie(){
        children=new Trie[26];
        isEnd=false;
    }
    public void insert(String word){
        Trie cur=this;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null)
                cur.children[c-'a']=new Trie();
            cur=cur.children[c-'a'];
        }
        cur.isEnd=true;
    }
    public boolean search(String word){
        Trie cur=this;
        for(char c:word.toCharArray()){
            if(cur.children[c-'a']==null)
                return false;
            cur=cur.children[c-'a'];
        }
        return cur.isEnd;
    }
    public boolean startsWith(String prefix){
        Trie cur=this;
        for(char c:prefix.toCharArray()){
            if(cur.children[c-'a']==null)
                return false;
            cur=cur.children[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */