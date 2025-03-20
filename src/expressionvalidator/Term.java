package expressionvalidator;

import java.util.HashMap;
import java.util.Map;

public class Term {
    private int coefficient;
    private Map<String, Integer> variables;

    public Term(int coefficient, Map<String, Integer> variables) {
        this.coefficient = coefficient;
        this.variables = variables;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public Map<String, Integer> getVariables() {
        return variables;
    }

    public Term multiply(Term other) {
        int newCoefficient = this.coefficient * other.coefficient;
        Map<String, Integer> newVariables = new HashMap<>(this.variables);

        for (Map.Entry<String, Integer> entry : other.variables.entrySet()) {
            newVariables.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return new Term(newCoefficient, newVariables);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (coefficient != 1) sb.append(coefficient);

        for (Map.Entry<String, Integer> entry : variables.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() != 1) {
                sb.append("^").append(entry.getValue());
            }
        }

        return sb.toString();
    }
}
