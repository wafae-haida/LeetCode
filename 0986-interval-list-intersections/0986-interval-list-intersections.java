class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[][] {};
        }
        int f = 0;
        int s = 0;
        List<int[]> ans = new ArrayList<>();
        while (f < firstList.length && s < secondList.length) {
            int startMax = Math.max(firstList[f][0], secondList[s][0]);
            int endMin = Math.min(firstList[f][1], secondList[s][1]);
            if (startMax <= endMin) {
                ans.add(new int[] { startMax, endMin });
            }
            if (firstList[f][1] < secondList[s][1]) {
                f++;
            } else {
                s++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
