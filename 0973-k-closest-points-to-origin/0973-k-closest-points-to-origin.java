class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if( k == points.length)
           return points;
        Queue<int[]> maxHeap = new PriorityQueue<>((a,b) -> (int)(Math.pow(b[0],2) + Math.pow(b[1],2)) 
        - (int)(Math.pow(a[0],2) + Math.pow(a[1],2)));

        for(int  i = 0 ; i < points.length; i++){
            maxHeap.add(new int[]{points[i][0],points[i][1]});
            if(maxHeap.size() > k){
                maxHeap.poll();
            }     
        }
        
        return maxHeap.toArray(new int[][]{});
    }
}