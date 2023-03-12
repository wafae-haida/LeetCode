class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int netGas = 0, totalGas = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            netGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            if(netGas < 0){
                start = i + 1;
                netGas = 0;
            }
        }
        return totalGas >= 0 ? start : -1;
    }
}
