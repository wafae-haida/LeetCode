
class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int[] courseDegree = new int[numCourses];
        int[] ans =  new int[numCourses];
        Map<Integer,List<Integer>> adjCourses = new HashMap<>();
        
        for(int i=0;i<pre.length;i++){
            int firstC=pre[i][1];
            int lastC=pre[i][0];
            List<Integer> list = adjCourses.getOrDefault(firstC,new ArrayList<Integer>());
            list.add(lastC);
            adjCourses.put(firstC,list);
            courseDegree[lastC]+=1;
        }
        Queue<Integer> bfs = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(courseDegree[i]==0)bfs.add(i);
        }
        int counter=0;
        while(!bfs.isEmpty()){
            int course=bfs.remove();
            ans[counter++]=course;
            if(adjCourses.containsKey(course)){
                for(Integer val : adjCourses.get(course)){
                courseDegree[val]--;
                if(courseDegree[val]==0)bfs.add(val);
            }
            }
          
        }
        if(counter==numCourses)return ans;
        return new int[]{};
    }
}
