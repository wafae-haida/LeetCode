class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>(numCourses);
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<Integer>());
        int[] visited=new int[numCourses];
        for(int[] pre:prerequisites)
             adj.get(pre[0]).add(pre[1]);
        for(int i=0;i<adj.size();i++){
            if(visited[i]==0 && isCycle(adj,visited,i))
                return false;
        }
        return true;    
    }
    public boolean isCycle(List<List<Integer>> adj, int[] visited, int course){
        if(visited[course]==2)
            return true;
        visited[course]=2;
        for(int i=0;i<adj.get(course).size();i++){
                if(visited[adj.get(course).get(i)]!=1 && isCycle(adj,visited,adj.get(course).get(i)))
                return true;
        }
        visited[course]=1;
        return false;
    }
}