class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList();
        int len = (int)Math.log10(n);
        int digit = n/(int)Math.pow(10,len);
        int i = 1;
        for(;i<=9;i++){
            if (i>n) break;
            list.add(i);
            helper(i,n,list);
        }

        return list;
    }

    private void helper(int i ,int n, List<Integer> list){
        i *= 10;
        for(int j=0;j<=9;j++){
            if (i+j>n) break;
            list.add(i+j);
            helper(i+j, n, list);
        }
    }
}