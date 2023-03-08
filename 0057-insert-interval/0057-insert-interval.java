class Solution {
    public boolean doesOverlap(int[] cur, int[] interval){
        return Math.min(cur[1],interval[1]) - Math.max(cur[0], interval[0]) >=0;
    }
    public int[] merge(int[] cur,int[] interval){
        int start = Math.min(cur[0],interval[0]);
        int end = Math.max(cur[1],interval[1]);
        return new int[]{start,end};
    }
    public int[][] insertInterval(int[][] intervals,int[] newInterval){
        List<int[]> ans = new ArrayList<>(Arrays.asList(intervals));
        boolean inserted = false;
        for(int i = 0 ; i < intervals.length; i++){
            if(newInterval[0] < intervals[i][0]){
                ans.add(i,newInterval);
                inserted = true;
                break;
            }
        }
        if(!inserted)
            ans.add(newInterval);
        return ans.toArray(new int[ans.size()][2]);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        intervals = insertInterval(intervals, newInterval);
        List<int[]> res = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            int[] cur = intervals[i];
            while(i < intervals.length && doesOverlap(cur,intervals[i])){
                cur = merge(cur,intervals[i]);
                i++;
            }
            i--;
            res.add(cur);
        }
        return res.toArray(new int[res.size()][2]);
    }
}