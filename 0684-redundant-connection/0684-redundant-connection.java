class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n];
        for(int i = 0 ; i < n; i++)
            parent[i] = i+1;
        for(int[] edge :edges){
            if(findParent(edge[0]) == findParent(edge[1]))
                return edge;
            union(edge[0],edge[1]);
        }
        return new int[]{};
    }
    public int findParent(int vertix){
        if(vertix == parent[vertix-1])
            return vertix;
        return findParent(parent[vertix-1]);
    }
    public void union(int first,int second){
        parent[findParent(first) - 1] = findParent(second);
    }
    
}