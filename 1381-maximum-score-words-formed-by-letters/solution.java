class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        HashMap<Character, Integer> letterScore = new HashMap<>();
        for (Character letter : letters) {
            letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
            letterScore.put(letter, score[letter - 'a']);
        }

        return dfsMaxScoreWords(words, 0, letterCount, letterScore);
    }

    public int dfsMaxScoreWords(String[] words, int index, HashMap<Character, Integer> letterCount, HashMap<Character, Integer> letterScore) {
        int maxScore = 0;
        for (int i = index; i < words.length; i++) {
            String word = words[i];
            HashMap<Character, Integer> workingMap = new HashMap<>(letterCount);
            boolean completedWord = true;
            int wordScore = 0;
            for (Character character : word.toCharArray()) {
                if (workingMap.containsKey(character)){
                    int decremented = workingMap.get(character) - 1;
                    wordScore += letterScore.get(character);
                    if (decremented == 0) {
                        workingMap.remove(character);
                    } else {
                        workingMap.put(character, decremented);
                    }
                } else {
                    completedWord = false;
                    break;
                }
            }
            if (completedWord) {
                maxScore = Math.max(maxScore, wordScore + dfsMaxScoreWords(words, i + 1, workingMap, letterScore));
            }
        }
        return maxScore;
    }
}