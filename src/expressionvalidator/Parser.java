package expressionvalidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    public static Expression parse(String expr) {
        String[] termStrings = expr.split("\\*");
        List<Term> terms = new ArrayList<>();

        for (String termString : termStrings) {
            terms.add(parseTerm(termString.trim()));
        }

        return new Expression(terms);
    }

    private static Term parseTerm(String termString) {
        int coefficient = 1;
        Map<String, Integer> variables = new HashMap<>();

        String[] parts = termString.split("[a-zA-Z]+");

        if (parts[0].length() > 0) {
            coefficient = Integer.parseInt(parts[0]);
        }

        String[] variableParts = termString.split("[0-9]+");
        for (String variable : variableParts) {
            if (variable.length() > 0) {
                variables.put(variable, variables.getOrDefault(variable, 0) + 1);
            }
        }

        return new Term(coefficient, variables);
    }
}
