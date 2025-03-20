package expressionvalidator;

import java.util.ArrayList;
import java.util.List;

public class Expression {
    private List<Term> terms;

    public Expression(List<Term> terms) {
        this.terms = terms;
    }

    public List<Term> getTerms() {
        return terms;
    }

    public Expression multiply(Expression other) {
        List<Term> resultTerms = new ArrayList<>();

        for (Term term1 : this.terms) {
            for (Term term2 : other.terms) {
                resultTerms.add(term1.multiply(term2));
            }
        }

        return new Expression(resultTerms);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Term term : terms) {
            if (sb.length() > 0 && term.getCoefficient() > 0) {
                sb.append("+");
            }
            sb.append(term.toString());
        }
        return sb.toString();
    }
}
