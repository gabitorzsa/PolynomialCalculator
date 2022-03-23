package controller;

import model.Monomial;
import model.Polynomial;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public Polynomial createPolynomial(String userInput) {
        String monomialFormat = "([+-]?[\\d\\.]*)([a-zA-Z]?)\\^?(\\d*)";
        Polynomial result = new Polynomial();

        Pattern p = Pattern.compile(monomialFormat);
        Matcher m = p.matcher(userInput);
        while(!m.hitEnd()){
            double coeff = 0;
            int pow = 0;
            m.find();
            coeff = Double.valueOf(m.group(1));
            pow = Integer.valueOf(m.group(3));
            Monomial b = new Monomial(coeff, pow);
            result.getPolynomial().add(b);
        }
        return result;
    }
}
