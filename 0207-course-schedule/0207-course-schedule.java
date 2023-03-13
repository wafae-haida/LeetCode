class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++)
            adj.add(new ArrayList<>());
        
        int[] visited = new int[numCourses];
        for(int i = 0 ; i < prerequisites.length ; i++)
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        
        for(int i = 0 ; i < numCourses; i++){
            if(visited[i] == 0 && isCycle(visited,adj,i))
                return false;
        }
       return true;
    }
    public boolean isCycle(int[] visited, List<List<Integer>> adj, int course){
        if(visited[course] == 2)
            return true;
        visited[course] = 2;
        for(int i = 0 ; i< adj.get(course).size() ; i++){
            if(visited[adj.get(course).get(i)] != 1 && isCycle(visited,adj,adj.get(course).get(i)))
                return true;
        }
        visited[course] = 1;
        return false;
    }
}