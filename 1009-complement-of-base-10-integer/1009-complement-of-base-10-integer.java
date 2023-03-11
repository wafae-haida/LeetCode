class Solution {
    public int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        int ans = 0;
        int fac = 1;
        while(n != 0){
            ans += fac * (n % 2 == 0?1:0);
            fac *=2;
            n /= 2;
        }
        return ans;
    }
}
