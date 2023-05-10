class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        $n = strlen($s);
        $map = array();
        $ans = $i = 0;
        for ($j = 0; $j < $n; $j++) {
            if (array_key_exists($s[$j],$map)) {
                $i = max($map[$s[$j]], $i);
            }
            $ans = max($ans, $j - $i + 1);
            $map[$s[$j]] = $j + 1;
        }
        return $ans;
    }

}