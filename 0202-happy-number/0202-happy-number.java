class Solution {
    public boolean isHappy(int n) {
        int sum = squaresSum(n);
        Set<Integer> counted = new HashSet<>();
        while(sum != 1){
            if(!counted.add(sum))
                return false;
            sum = squaresSum(sum);
        }
        return true;
    }
    public int squaresSum(int n){
        int total = 0;
        int cur = n;
        while(cur != 0){
            int tmp = cur % 10;
            total += Math.pow(tmp,2);
            cur = cur / 10;
        }
        return total;
    }
}