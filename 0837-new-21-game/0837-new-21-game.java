class Solution {
    public double new21Game(int N, int K, int W) {
        double[] dp = new double[N + W + 1];
        // dp[x] = the answer when Alice has x points
        for (int i = K; i <= N; ++i)
            dp[i] = 1.0;
        // n-k+1 refer to valid scores that alice can make, if w > n-k+1 w contain invalid solutions we don't want to count
        double sum = Math.min(N - K + 1, W);
        //S = dp[K] + dp[K+1] + ... + dp[K+W-1] is equivalent to setting S = Math.min(N - K + 1, W) 
        for (int j = K - 1; j >= 0; --j) {
            dp[j] = sum / W;
            sum += dp[j] - dp[j + W];
        }
        return dp[0];
    }
}