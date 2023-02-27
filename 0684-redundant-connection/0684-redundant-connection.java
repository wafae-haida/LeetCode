class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length];
        for(int i=0;i<edges.length;i++)
            parent[i]=i+1;
        
        for(int[] edge : edges){
            if(findParent(edge[0]) == findParent(edge[1]))
                return edge;
            union(edge[0],edge[1]);
        }
        return new int[2];
    }
    public int findParent(int node){
        if(node==parent[node-1])
            return node; 
        return findParent(parent[node-1]);
    }
    public void union(int firstNode,int secondNode){
        parent[findParent(firstNode)-1] = findParent(secondNode);
    }
}