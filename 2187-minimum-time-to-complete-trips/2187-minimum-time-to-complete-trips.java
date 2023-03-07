class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int max_Time = 0;
        for(int t :time)
            max_Time = Math.max(max_Time, t);
        long left = 1, right = (long) totalTrips * max_Time;
        while(left < right){
            long mid = left + (right - left)/2;
            if(timeIsEnough(time,totalTrips,mid))
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }
    public boolean timeIsEnough(int[] time,int totalTrips,long mid){
        long finished_Trips = 0;
        for(int t:time)
            finished_Trips += mid/t;
        return finished_Trips >= totalTrips;
    }
}