class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int preEnd = ans.get(ans.size() - 1)[1];
            int curStart = intervals[i][0];
            if(preEnd >= curStart){
                ans.get(ans.size() - 1)[1] = Math.max(preEnd, intervals[i][1]);
            }else
                ans.add(new int[]{curStart,intervals[i][1]});
        }
        int[][] res = new int[ans.size()][2];
        return ans.toArray(res);
    }
}