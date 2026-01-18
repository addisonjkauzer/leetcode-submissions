class Solution {
    ArrayList<Integer> players = new ArrayList<>();
    public int findTheWinner(int n, int k) {
        for (int i = 1; i <= n; i++) {
            players.add(i);
        }
        Integer index = 0;
        while (players.size() != 1) {
            index = (((index + k) - 1  % players.size()) + players.size()) % players.size();
            players.remove((int)index);
            System.out.println(players);
        }
        return players.get(0);
    }
}