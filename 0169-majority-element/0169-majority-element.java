/*
[12,5,8,3,6,-9,-9,9] occu>n/2

Doube maj=n/2
Map
*/
class Solution {
    public int majorityElement(int[] nums) {
        Double mjr=nums.length/2.0;
        Map<Integer,Integer> dic=new HashMap<>();
        for(int val:nums)
            dic.put(val,dic.getOrDefault(val,0)+1);
        for(Map.Entry<Integer,Integer> elm:dic.entrySet()){
            if(elm.getValue()>mjr) return elm.getKey();
        }
        return 0;
    }
}