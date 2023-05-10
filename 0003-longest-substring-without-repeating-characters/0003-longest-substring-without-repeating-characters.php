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
            if (isset($map[$s[$j]])) {
                $i = max($map[$s[$j]], $i);
            }
            $ans = max($ans, $j - $i + 1);
            $map[$s[$j]] = $j + 1;
        }
        return $ans;
    }

}