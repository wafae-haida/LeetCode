class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0)return tasks.length;
        Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        Queue<Pair<Integer,Integer>> queue=new LinkedList<>();
        int[] arr=new int[26];
        for(char c:tasks)
            arr[c-'A']++;
        for(int val:arr){
            if(val>0)
                maxHeap.add(val);
        }
        int time=0;
        
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!maxHeap.isEmpty()){
                int val=maxHeap.poll();
                val--;
                if(val>0)
                    queue.add(new Pair(val,time+n));
            }
            if(!queue.isEmpty() && queue.peek().getValue()==time)
                maxHeap.add(queue.poll().getKey());
        }
            
        return time;
    }
}