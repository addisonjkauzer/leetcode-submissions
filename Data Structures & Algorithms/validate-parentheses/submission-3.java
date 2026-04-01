class Solution {
    public boolean isValid(String s) {
        final Stack<Character> characterStack = new Stack<>();

        for (final Character character : s.toCharArray()) {
            switch (character) {
                case '(':
                    characterStack.push(character);
                    break;
                case '{':
                    characterStack.push(character);
                    break;
                case '[':
                    characterStack.push(character);
                    break;
                case ')':
                    if (characterStack.size() == 0) {
                        return false;
                    }
                    Character lastParen = characterStack.pop();
                    if  (!lastParen.equals('(')) {
                        return false;
                    }
                    break;
                case '}':
                    if (characterStack.size() == 0) {
                        return false;
                    }
                    lastParen = characterStack.pop();
                    if  (!lastParen.equals('{')) {
                        return false;
                    }
                    break;
                case ']':
                    if (characterStack.size() == 0) {
                        return false;
                    }
                    lastParen = characterStack.pop();
                    if  (!lastParen.equals('[')) {
                        return false;
                    }
                    break;
            }
        }
        if (characterStack.size() == 0) {
            return true;
        }
        return false;
        
    }
}
