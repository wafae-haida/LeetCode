class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] degree = new int[numCourses];
        int[] res = new int[numCourses];
        for(int[] pre : prerequisites){
            List<Integer> list = adjList.getOrDefault(pre[1], new ArrayList<>());
            list.add(pre[0]);
            adjList.put(pre[1], list);
            degree[pre[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < numCourses; i++){
            if(degree[i] == 0)
                queue.add(i);
        }
        int  i =0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            res[i++] = course;
            if(adjList.containsKey(course)){
                List<Integer> lst = adjList.get(course);
                for(int cr : lst){
                    degree[cr]--;
                    if(degree[cr] == 0)
                        queue.add(cr);
                }
            }
        }
        if(i < numCourses)
            return new int[]{};
        return res;
    }
}