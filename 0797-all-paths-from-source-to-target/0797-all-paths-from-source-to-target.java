//DFS->recursion, BFS->Queue
/*
    DAG:node 0 i have to reach node n-1 (n is the total number of nodes) and return the different paths
    0,0->first node that i can reach
    first node->first first node i ll compare it s whigh if it s equal to n-1


*/

class Solution {
    List<List<Integer>> ans= new ArrayList<List<Integer>>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> curr=new ArrayList<>();
        curr.add(0);
        dfs(graph,0,curr,ans);
        return ans;
    }
    public void dfs(int[][] graph,int start,List<Integer> curr,List<List<Integer>> ans){
        if(start==graph.length-1){
            ans.add(new ArrayList<>(curr)); 
            return;
        }
        for(int i : graph[start]){
            curr.add(i);
            dfs(graph,i,curr,ans);
            curr.remove(curr.size()-1);
        }
        
        return;
    }
}