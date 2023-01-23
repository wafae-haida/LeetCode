/*
   seeck out for bi in the rows and so on 
   if bi is not in prerequisites[i] return false
   


*/
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        List<List<Integer>> adjs= new ArrayList<>();
        for(int i=0;i<numCourses;i++)adjs.add(new ArrayList<>());
        for(int i=0;i<prerequisites.length;i++)adjs.get(prerequisites[i][0]).add(prerequisites[i][1]);
        int[] visited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(visited[i]==0){
                if(isCycle(adjs,visited,i)) return false;
            }
        }
        return true;
    }
    public boolean isCycle(List<List<Integer>> adjs,int[] visited, int curr){
        if(visited[curr]==2)return true;
        visited[curr]=2;
        for(int i=0;i<adjs.get(curr).size();i++){
            if(visited[adjs.get(curr).get(i)]!=1){
               if(isCycle(adjs,visited,adjs.get(curr).get(i))) return true;
            }
        }
        visited[curr]=1;
        return false;
    }
   
}