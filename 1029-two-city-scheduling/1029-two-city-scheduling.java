class Pair{
    int costA;
    int costB;
    int difference;
    int index;
    public Pair(int costA, int costB, int difference, int index){
        this.costA =costA;
        this.costB = costB;
        this.difference = difference;
        this.index = index;
    }
    public int getDifference(){
        return difference;
    }
}
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Pair[] difference = new Pair[costs.length];
        for(int i = 0 ; i < costs.length ; i++){
            int df = costs[i][0] - costs[i][1];
            difference[i] = new Pair(costs[i][0], costs[i][1], df, i);
        }
        Arrays.sort(difference, (a,b)->a.getDifference() - b.getDifference());
        int ans = 0;
        for(int i = 0 ; i < difference.length ; i++){
            if(i < difference.length / 2)
                ans += difference[i].costA;
            else
                ans += difference[i].costB;
        }
        return ans;
    }
}