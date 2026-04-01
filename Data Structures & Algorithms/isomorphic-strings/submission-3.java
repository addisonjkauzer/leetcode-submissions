class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sCharMap = new HashMap<>();
        HashMap<Character, Character> tCharMap = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            if (sCharMap.containsKey(sChar)) {
                if (sCharMap.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (tCharMap.containsKey(tChar)) {
                    if (tCharMap.get(tChar) != sChar) {
                        return false;
                    }
                }
                sCharMap.put(sChar, tChar);
                tCharMap.put(tChar, sChar);
            }
        }
        return true;
        
    }
}