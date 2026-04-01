class Twitter {
    HashMap<Integer, Set<Integer>> userToFollowees;
    HashMap<Integer, Queue<Integer[]>> userToPosts;
    Integer postIterator;

    public Twitter() {
        userToFollowees = new HashMap<>();
        userToPosts = new HashMap<>();
        postIterator = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Queue<Integer[]> posts = userToPosts.getOrDefault(userId, new LinkedList<>());
        posts.add(new Integer[]{tweetId, postIterator});
        if (posts.size() > 10) {
            posts.poll();
        }
        userToPosts.put(userId, posts);
        postIterator++;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> folowees = userToFollowees.getOrDefault(userId, new HashSet<>());

        PriorityQueue<Integer[]> feed = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        
        for (Integer[] post : userToPosts.getOrDefault(userId, new LinkedList<>())) {
            feed.add(post);
        }

        for (Integer folowee : folowees) {
            for (Integer[] post : userToPosts.getOrDefault(folowee, new LinkedList<>())) {
                feed.add(post);
            }
            while (feed.size() > 10) {
                feed.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!feed.isEmpty()) {
            res.add(feed.poll()[0]);
        }
        Collections.reverse(res);
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        Set<Integer> followees = userToFollowees.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        userToFollowees.put(followerId, followees);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = userToFollowees.getOrDefault(followerId, new HashSet<>());
        followees.remove(followeeId);
        userToFollowees.put(followerId, followees);
    }
}
