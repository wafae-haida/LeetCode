class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target) {
        $length = count($nums);
        $map = array();
        for($i=0;$i<$length;$i++){
            $complement = $target - $nums[$i];
            if(array_key_exists($complement, $map))
                return array($map[$complement],$i);
            $map[$nums[$i]] = $i;
        }
        return array();
    }

}