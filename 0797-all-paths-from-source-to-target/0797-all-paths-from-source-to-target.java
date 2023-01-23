//DFS->recursion, BFS->Queue
/*
    DAG:node 0 i have to reach node n-1 (n is the total number of nodes) and return the different paths
    0,0->first node that i can reach
    first node->first first node i ll compare it s whigh if it s equal to n-1


*/

class Solution{
    public List<List<Integer>> allPathsSourceTarget(int[][] graph){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        Queue<List<Integer>> queue= new LinkedList<>();
        queue.add(curr);
        while(!queue.isEmpty()){
            curr=queue.poll();
            int start= curr.get(curr.size()-1);
            if(start==graph.length-1){
                ans.add(curr);
                continue;
            }
            for(int i:graph[start]){
                List<Integer> temp=new ArrayList<>(curr);
                temp.add(i);
                queue.add(temp);
            }
        }
        return ans;
    }
}