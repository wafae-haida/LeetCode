class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum_cost = 0;
        int sum_gas = 0;
        for(int i = 0 ; i < gas.length ; i++){
            sum_cost += cost[i];
            sum_gas += gas[i];
        }
        if(sum_cost > sum_gas)
            return -1;
        int start_idx = 0;
        int cur_gas = 0;
        for(int i = 0 ; i < gas.length ; i++){
            cur_gas += gas[i] - cost[i];
            if(cur_gas < 0){
                start_idx = i + 1;
                cur_gas = 0;
            }
        }
        return start_idx;
    }
}