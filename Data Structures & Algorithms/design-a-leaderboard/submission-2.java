class Leaderboard {
    HashMap<Integer, Integer> playerToScore;
    TreeMap<Integer, Integer> scoreToNumberOfPlayers;

    public Leaderboard() {
        playerToScore = new HashMap<>();
        scoreToNumberOfPlayers = new TreeMap<>(Comparator.reverseOrder());
    }
    
    public void addScore(int playerId, int score) {
        Integer newScore =  playerToScore.getOrDefault(playerId, 0) + score;
        if (playerToScore.containsKey(playerId)) {
            reset(playerId);
        }
        playerToScore.put(playerId, newScore);
        scoreToNumberOfPlayers.put(newScore, scoreToNumberOfPlayers.getOrDefault(newScore, 0) + 1);
    }
    
    public int top(int K) {
        Integer scoreTotal = 0;
        Integer players = 0;
        for (int key : scoreToNumberOfPlayers.keySet()) {
            for (int i = 0; i < scoreToNumberOfPlayers.get(key); i++) {
                scoreTotal += key;
                players++;
                if (players == K) {
                    return scoreTotal;
                }
            }
        }
        return scoreTotal;
    }
    
    public void reset(int playerId) {
        Integer currentScore = playerToScore.get(playerId);
        playerToScore.remove(playerId);
        scoreToNumberOfPlayers.put(currentScore, scoreToNumberOfPlayers.get(currentScore) - 1);
        if (scoreToNumberOfPlayers.get(currentScore) == 0) {
            scoreToNumberOfPlayers.remove(currentScore);
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
