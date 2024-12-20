package zoho;

import java.util.*;

class LexicalAnalyzer {
    private String expression;
    private List<String> tokens;

    public LexicalAnalyzer(String expression) {
        this.expression = expression.replaceAll("\\s", ""); // Remove whitespace
        this.tokens = new ArrayList<>();
    }

    public List<String> tokenize() {
        StringBuilder token = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                token.append(c);
            } else if (c == '+' || c == '-' || c == '*' || c == '(' || c == ')') {
                if (token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0); // Clear token
                }
                tokens.add(String.valueOf(c));
            }
        }
        if (token.length() > 0) {
            tokens.add(token.toString());
        }
        return tokens;
    }
}

class AlgebraicExpression {
    private List<String> tokens;
    private StringBuilder result;

    public AlgebraicExpression(List<String> tokens) {
        this.tokens = tokens;
        this.result = new StringBuilder();
    }

    public String expandAndSimplify() {
        Stack<Integer> coefStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    applyOperator(coefStack, operatorStack.pop());
                }
                operatorStack.pop(); // Pop the opening parenthesis
            } else if (token.equals("+") || token.equals("-") || token.equals("*")) {
                while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(token)) {
                    applyOperator(coefStack, operatorStack.pop());
                }
                operatorStack.push(token);
            } else {
                // Process coefficients and variables
                int coef = 1;
                String var = token;
                int index = token.length() - 1;
                if (Character.isDigit(token.charAt(index))) {
                    while (index >= 0 && Character.isDigit(token.charAt(index))) {
                        index--;
                    }
                    coef = Integer.parseInt(token.substring(0, index + 1));
                    var = token.substring(index + 1);
                }
                if (!coefStack.isEmpty() && operatorStack.peek().equals("*")) {
                    coef *= coefStack.pop();
                    operatorStack.pop();
                }
                coefStack.push(coef);
                result.append(coef).append(var);
            }
        }

        while (!operatorStack.isEmpty()) {
            applyOperator(coefStack, operatorStack.pop());
        }

        return result.toString();
    }

    private void applyOperator(Stack<Integer> coefStack, String operator) {
        if (operator.equals("+")) {
            result.append("+");
        } else if (operator.equals("-")) {
            result.append("-");
        } else if (operator.equals("*")) {
            int coef2 = coefStack.pop();
            int coef1 = coefStack.pop();
            coefStack.push(coef1 * coef2);
        }
    }

    private int precedence(String operator) {
        if (operator.equals("*")) {
            return 2;
        } else if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else {
            return 0;
        }
    }
}


public class AlgebraicExpressionExpander {
    public static void main(String[] args) {
        String input1 = "(2x+y)*(3x-5y)";
        String input2 = "(2xy+4x^2y)*(2x^2y+6xy)";
        String input3 = "(2x^2y+3xy^2z-xz^3)*(5xyz+3y^2z-2z)";

        System.out.println("Input: " + input1);
        List<String> tokens1 = new LexicalAnalyzer(input1).tokenize();
        String output1 = new AlgebraicExpression(tokens1).expandAndSimplify();
        System.out.println("Output: " + output1);

        System.out.println("\nInput: " + input2);
        List<String> tokens2 = new LexicalAnalyzer(input2).tokenize();
        String output2 = new AlgebraicExpression(tokens2).expandAndSimplify();
        System.out.println("Output: " + output2);

        System.out.println("\nInput: " + input3);
        List<String> tokens3 = new LexicalAnalyzer(input3).tokenize();
        String output3 = new AlgebraicExpression(tokens3).expandAndSimplify();
        System.out.println("Output: " + output3);
    }
}
