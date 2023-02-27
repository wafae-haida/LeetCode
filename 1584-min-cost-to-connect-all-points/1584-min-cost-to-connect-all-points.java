class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        Set<Integer> visited = new HashSet<>();
        Queue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        minHeap.add(new int[]{0,0});
        int cost=0;
        
        while(visited.size() < points.length){
            int[] arr = minHeap.poll();
            int tmp = arr[0];
            int point = arr[1];
            if(visited.contains(point))
                continue;
            visited.add(point);
            cost += tmp;
            for(int i = 0 ; i < points.length ; i++){
                if(!visited.contains(i)){
                    int weight = Math.abs(points[i][0] - points[point][0]) + Math.abs(points[i][1] - points[point][1]);
                    minHeap.add(new int[]{weight,i});
                }
            }
        }
        
        return cost;
    }     
}