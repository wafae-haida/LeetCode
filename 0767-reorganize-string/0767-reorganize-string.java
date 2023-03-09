class Solution {
    public String reorganizeString(String s) {
        Map<Character,Integer> dic = new HashMap<>();
        for(char c : s.toCharArray())
            dic.put(c,dic.getOrDefault(c,0) + 1);
        Queue<Map.Entry<Character,Integer>> most_freq = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        most_freq.addAll(dic.entrySet());
        StringBuilder res = new StringBuilder();
        while(!most_freq.isEmpty()){
            Map.Entry<Character,Integer> tmp = most_freq.poll();
            if(res.length() == 0 || tmp.getKey() != res.charAt(res.length() - 1)){
                res.append(tmp.getKey());
                tmp.setValue(tmp.getValue() - 1);
            }else{
                Map.Entry<Character,Integer> tmp2 = most_freq.poll();
                if(tmp2 == null)
                    return "";
                res.append(tmp2.getKey());
                tmp2.setValue(tmp2.getValue() - 1);
                if(tmp2.getValue() > 0)
                    most_freq.offer(tmp2);
            }
              if(tmp.getValue() > 0)
                    most_freq.offer(tmp);
        }
        return res.toString();
    }
}