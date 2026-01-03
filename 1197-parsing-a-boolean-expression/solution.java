class Solution {
    public boolean parseBoolExpr(String expression) {
        System.out.println(expression);
        switch (expression.charAt(0)) {
            case 't':
                return true;
            case 'f':
                return false;
            case '!':
                return !parseBoolExpr(expression.substring(2, expression.length() - 1));
            case '&':
                String subBoolExpr = expression.substring(2, expression.length() - 1);
                List<String> subBoolExpressions = splitBooleanChunks(subBoolExpr);
                boolean result = true;
                for (String subBoolExpression : subBoolExpressions) {
                    result &= parseBoolExpr(subBoolExpression.trim());
                }
                return result;
            case '|':
                subBoolExpr = expression.substring(2, expression.length() - 1);
                subBoolExpressions = splitBooleanChunks(subBoolExpr);
                result = false;
                for (String subBoolExpression : subBoolExpressions) {
                    result |= parseBoolExpr(subBoolExpression.trim());
                }
                return result;
        }
        return false;
    }

    public List<String> splitBooleanChunks(String expression) {
        List<String> chunks = new ArrayList<>();
        Integer startIndex = 0;
        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);
            if (character == '&' || character == '|') {
                int parenCounter = 1;
                i += 2;
                while (parenCounter != 0) {
                    char subCharacter = expression.charAt(i);
                    if (subCharacter == '(') {
                        parenCounter++;
                    }
                    if (subCharacter == ')') {
                        parenCounter--;
                    }
                    i++;
                }
                i--;
                continue;
            }
            if (character == ',') {
                chunks.add(expression.substring(startIndex, i));
                startIndex = i + 1;
            }
        }
        chunks.add(expression.substring(startIndex, expression.length()));
        return chunks;
    }
}