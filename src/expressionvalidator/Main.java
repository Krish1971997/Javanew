package expressionvalidator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String expr1 = "(2x+y)*(3x-5y)";
        String expr2 = "(2xy+4x^2y)*(2x^2y+6xy)";
        String expr3 = "(2x^2y+3xy^2z-xz^3)*(5xyz+3y^2z-2z)";

        // Parse the expressions
        Expression expression1 = Parser.parse(expr1);
        Expression expression2 = Parser.parse(expr2);
        Expression expression3 = Parser.parse(expr3);

        // Multiply expressions
        Expression result1 = expression1.multiply(expression2);
        Expression result2 = expression2.multiply(expression3);

        // Format and print the results
        System.out.println("Result of multiplication: " + Formatter.format(result1));
        System.out.println("Result of multiplication: " + Formatter.format(result2));
    }
}
