package model;

public class Monomial {

    private double coefficient;
    private int power;

    public Monomial() {
        this.coefficient = 0.0;
        this.power = 0;
    }

    public Monomial(double coefficient, int power) {
        this.coefficient = coefficient;
        this.power = power;
    }

    public Monomial addition(Monomial m2) {
        Monomial result = new Monomial();
        result.setCoefficient(this.getCoefficient() + m2.getCoefficient());
        result.setPower(this.getPower());
        return result;
    }
    public Monomial subtraction(Monomial m2) {
        Monomial result = new Monomial();
        result.setCoefficient(this.getCoefficient() - m2.getCoefficient());
        result.setPower(this.getPower());
        return result;
    }

    public Monomial multiplication(Monomial m2) {
        Monomial result = new Monomial();
        result.setCoefficient(this.getCoefficient() * m2.getCoefficient());
        result.setPower(this.getPower() + m2.getPower());
        return result;
    }

    /* Not implemented
    public model.Monomial division(model.Monomial m2) {
        model.Monomial result = new model.Monomial(this.getCoefficient() / m2.getCoefficient(), this.getPower() - m2.getPower());
        return result;
    }
     */
    @Override
    public String toString() {
        String monomialRepresentation = String.format("%.2f", coefficient);
        if(coefficient >= 0) {
            return "+" + coefficient + "x^" + power;
        } else {
            return coefficient + "x^" + power;
        }
    }
    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
