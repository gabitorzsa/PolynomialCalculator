package model;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {

    // list of monomials forming polynomial
    private List<Monomial> polynomial = new ArrayList<Monomial>();
    ///// Operations /////
    // Addition
    public Polynomial add(Polynomial Q) {
        Polynomial result = new Polynomial();
        Monomial aux = new Monomial(0,0);
        Monomial m1 = new Monomial(0, 0);
        Monomial m2 = new Monomial(0, 0);

        int lengthPolynomialP = this.polynomial.size();
        int lengthPolynomialQ = Q.polynomial.size();

        int i = 0, j = 0;
        while (i < lengthPolynomialP && j < lengthPolynomialQ) {
            m1 = this.polynomial.get(i);
            m2 = Q.polynomial.get(j);

            if(m1.getPower() > m2.getPower()) {
                result.polynomial.add(m1);
                i++;
            } else if(m1.getPower() < m2.getPower()) {
                result.polynomial.add(m2);
                j++;
            } else {
                aux = m1.addition(m2);
                result.polynomial.add(aux);
                i++; j++;
            }
        }
        while(i < lengthPolynomialP) {
            m1 = this.polynomial.get(i);
            result.polynomial.add(m1);
            i++;
        }
        while(j < lengthPolynomialQ) {
            m2 = Q.polynomial.get(j);
            result.polynomial.add(m2);
            j++;
        }
        return result;
    }

    // Subtraction
    public Polynomial sub(Polynomial Q) {
        Polynomial result = new Polynomial();
        Monomial aux = new Monomial(0,0);
        Monomial m1 = new Monomial(0, 0);
        Monomial m2 = new Monomial(0, 0);

        int lengthPolynomialP = this.polynomial.size();
        int lengthPolynomialQ = Q.polynomial.size();

        int i = 0, j = 0;
        while (i < lengthPolynomialP && j < lengthPolynomialQ) {
            m1 = this.polynomial.get(i);
            m2 = Q.polynomial.get(j);

            if(m1.getPower() > m2.getPower()) {
                result.polynomial.add(m1);
                i++;
            } else if(m1.getPower() < m2.getPower()) {
                m2.setCoefficient((-1.0) * m2.getCoefficient());
                result.polynomial.add(m2);
                j++;
            } else {
                aux = m1.subtraction(m2);
                result.polynomial.add(aux);
                i++; j++;
            }
        }
        while(i < lengthPolynomialP) {
            m1 = this.polynomial.get(i);
            result.polynomial.add(m1);
            i++;
        }
        while(j < lengthPolynomialQ) {
            m2 = Q.polynomial.get(j);
            m2.setCoefficient((-1.0) * m2.getCoefficient());
            result.polynomial.add(m2);
            j++;
        }
        return result;
    }

    // Multiplication
    public Polynomial mul(Polynomial Q) {
        Monomial aux = new Monomial(0, 0);
        Polynomial result = new Polynomial();

        for(Monomial m : this.polynomial) {
            Polynomial temp = new Polynomial();
            for(Monomial n : Q.polynomial) {
                aux = m.multiplication(n);
                temp.polynomial.add(aux);
            }
            result = result.add(temp);
        }
        return result;
    }

    // Derivation
    public Polynomial der() {
        Polynomial result = new Polynomial();
        for(Monomial m : this.polynomial) {
            m.setCoefficient(m.getCoefficient() * m.getPower());
            m.setPower(m.getPower() - 1);
            result.polynomial.add(m);
        }
        return result;
    }

    // Integration
    public Polynomial integr() {
        Polynomial result = new Polynomial();
        for(Monomial m : this.polynomial) {
            Monomial aux = new Monomial();
            double coeff;
            int pow;
            coeff = m.getCoefficient();
            pow = m.getPower();
            if(pow >= 0) {
                pow++;
                coeff = coeff / (double)pow;
                aux.setCoefficient(coeff);
                aux.setPower(pow);
                result.polynomial.add(aux);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String s = "";
        for(int i = 0; i < polynomial.size(); i++)
            s += polynomial.get(i).toString();
        return s;
    }

    public List<Monomial> getPolynomial() {
        return polynomial;
    }
}
