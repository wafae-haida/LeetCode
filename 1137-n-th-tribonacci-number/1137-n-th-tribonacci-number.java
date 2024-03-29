class Solution {
    public int tribonacci(int n) {
        if( n == 0 || n == 1)
            return n;
        int[] t = new int[n + 1];
        t[1] = 1;
        t[2] = 1;
        for(int i = 3 ; i < n+1; i++){
            t[i] = t[i-1]+t[i-2]+t[i-3];
        }
        return t[n];
    }
}