class Twitter {
    Map<Integer,User> map;
    int clock = 0;
    
    class Tweet{
        int id;
        int time;
        Tweet next;
        
        Tweet(int id){
            this.id = id;
            time = clock++;
            next = null;
        }
    }
    class User{
        int id;
        Set<Integer> followed;
        Tweet twt;
        
        User(int id){
            this.id = id;
            followed = new HashSet<>();
            followed.add(id);
            twt = null;
        }
        
        void follow(int id){
            followed.add(id);
        }
        void unfollow(int id){
            followed.remove(id);
        }
        void post(int id_tweet){
            Tweet t = new Tweet(id_tweet);
            t.next = twt;
            twt = t;
        }
    }
    
    
    public Twitter() {
        map = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!map.containsKey(userId)){
            User u = new User(userId);
            map.put(userId,u);
        }
        map.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> lst = new LinkedList<>();
        if(!map.containsKey(userId))
            return lst;
        Set<Integer> users = new HashSet<>();
        users = map.get(userId).followed;
        Queue<Tweet> queue = new PriorityQueue<>((a,b)->b.time - a.time);
        for(int ur : users){
            Tweet t = map.get(ur).twt;
            if(t != null)
                queue.add(t);
        }
        int count = 0;
        while(!queue.isEmpty() && count < 10){
            Tweet tt = queue.poll();
            lst.add(tt.id);
            if(tt.next != null)
                queue.add(tt.next);
            count++;
        }
        return lst;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!map.containsKey(followerId)){
            User u = new User(followerId);
            map.put(followerId, u);
        }
        if(!map.containsKey(followeeId)){
            User u = new User(followeeId);
            map.put(followeeId, u);
        }
        map.get(followerId).follow(followeeId);    
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followeeId == followerId)
            return;
         if(map.containsKey(followerId))
           map.get(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */