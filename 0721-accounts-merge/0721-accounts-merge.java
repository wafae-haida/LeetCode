class DSU{
    int[] parent;
    int[] rank;
    DSU(int len){
       parent = new int[len];
        rank = new int[len];
        for(int i = 0 ; i < len; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }
   int find(int a){
        if(a == parent[a])
            return a;
        return find(parent[a]);
    }

    void union(int a, int b){
         if (find(a) == find(b))
            return;
        if(rank[find(a)] >= rank[find(b)]){
            rank[find(a)] += rank[find(b)];
            parent[find(a)] = find(b);
        }
        else{
            rank[find(b)] += rank[find(a)];
            parent[find(b)] = find(a);
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int len = accounts.size();
        DSU dsu = new  DSU(len);
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0 ; i < len; i++){
            int account_size = accounts.get(i).size();
            for(int j = 1 ; j < account_size ; j++){
                String name = accounts.get(i).get(0);
                String email = accounts.get(i).get(j);
                if(!map.containsKey(email))
                    map.put(email,i);
                else
                    dsu.union(i, map.get(email));
            }
        }
        Map<Integer, List<String>> emails_merge = new HashMap<>();
        for(String eml : map.keySet()){
            int idx = map.get(eml);
            int position = dsu.find(idx); 
            if(!emails_merge.containsKey(position))
                emails_merge.put(position,new ArrayList());
            emails_merge.get(position).add(eml);
        }
        List<List<String>> res = new ArrayList<>();
        for(int k : emails_merge.keySet()){
            List<String> lst = emails_merge.get(k);
            Collections.sort(lst);
            lst.add(0, accounts.get(k).get(0));
            res.add(new ArrayList<>(lst));
        }
        return res;
    }
}