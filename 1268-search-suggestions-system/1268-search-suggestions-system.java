class Trie{
    Trie[] children;
    boolean end;
    public Trie(){
        children = new Trie[26];
        end = false;
    }
    public void add_Product(String product){
        Trie cur = this;
        for(char c : product.toCharArray()){
            if(cur.children[c-'a']==null)
                cur.children[c-'a'] = new Trie();
            cur = cur.children[c-'a'];
        }
        cur.end = true;
    }
    public List<String> search_Word(String searchWord){
        List<String> lst = new ArrayList<>();
        Trie cur = this;
        for(char c : searchWord.toCharArray()){
            if(cur.children[c - 'a'] != null){
                cur = cur.children[c - 'a'];
            } else 
                return new ArrayList<>();
        }
        traverse(cur, searchWord, lst);
        return lst;
    }
    private void traverse(Trie cur, String searchWord, List<String> lst){
        if(cur.end){
            lst.add(searchWord);
            if(lst.size() == 3) return;
        }
        for(char c = 'a'; c <= 'z' && lst.size() < 3; c++){
            if(cur.children[c - 'a'] != null){
                traverse(cur.children[c - 'a'], searchWord + c, lst);
            }
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie tr = new Trie();
        List<List<String>> ans = new ArrayList<>();
        for(String product : products)
            tr.add_Product(product);
        String sch = "";
        for(char c :searchWord.toCharArray()){
            sch += c;
            List<String> lst = tr.search_Word(sch);
            ans.add(lst);
        }
        return ans;
    }
}
