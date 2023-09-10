class Solution {

    HashMap<Integer, Integer> amountToNumCoins = new HashMap();
    
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }

        if (amountToNumCoins.containsKey(amount)) {
            return amountToNumCoins.get(amount);
        }

        int minNumberOfCoins = Integer.MAX_VALUE;
        boolean hasSolution = false;
        for (int i = 0; i < coins.length; i++) {
            int newAmount = amount - coins[i];
            if (newAmount == 0) {
                return 1;
            }
            int remainingChange = coinChange(coins, newAmount);
            if (remainingChange >= 0) {
                minNumberOfCoins = Math.min(minNumberOfCoins, remainingChange + 1);
                hasSolution = true;
            }
        }
        if(hasSolution) {
            amountToNumCoins.put(amount, minNumberOfCoins);
            return minNumberOfCoins;
        }
        amountToNumCoins.put(amount, -1);
        return -1;

    }
}