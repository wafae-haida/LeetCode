class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> rowValues=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j>0 && i>0  && res.get(i-1).size()-1>=j){
                    rowValues.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
                else
                    rowValues.add(1);
            }
            res.add(rowValues);
        }
        return res;
    }
}