import controller.Regex;
import model.Polynomial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUnit {
    @Test
    public void additionTest() {
        Polynomial polynomialP = new Polynomial();
        Regex regex = new Regex();
        polynomialP = regex.createPolynomial("2x^3+3x^2-1x^1");
        Polynomial polynomialQ = new Polynomial();
        polynomialQ = regex.createPolynomial("1x^2+2x^1-3x^0");
        polynomialP = polynomialP.add(polynomialQ);
        Assertions.assertEquals(polynomialP.toString(),"+2.0x^3+4.0x^2+1.0x^1-3.0x^0");
    }
    @Test
    public void subtractionTest() {
        Polynomial polynomialP = new Polynomial();
        Regex regex = new Regex();
        polynomialP = regex.createPolynomial("2x^3+3x^2-1x^1");
        Polynomial polynomialQ = new Polynomial();
        polynomialQ = regex.createPolynomial("1x^2+2x^1-3x^0");
        polynomialP = polynomialP.sub(polynomialQ);
        Assertions.assertEquals(polynomialP.toString(),"+2.0x^3+2.0x^2-3.0x^1+3.0x^0");
    }
    @Test
    public void multiplicationTest() {
        Polynomial polynomialP = new Polynomial();
        Regex regex = new Regex();
        polynomialP = regex.createPolynomial("2x^3+3x^2-1x^1");
        Polynomial polynomialQ = new Polynomial();
        polynomialQ = regex.createPolynomial("1x^2+2x^1-3x^0");
        polynomialP = polynomialP.mul(polynomialQ);
        Assertions.assertEquals(polynomialP.toString(),"+2.0x^5+7.0x^4-1.0x^3-11.0x^2+3.0x^1");
    }
    @Test
    public void derivativeTest() {
        Polynomial polynomialP = new Polynomial();
        Regex regex = new Regex();
        polynomialP = regex.createPolynomial("2x^3+3x^2-1x^1");
        polynomialP = polynomialP.der();
        Assertions.assertEquals(polynomialP.toString(),"+6.0x^2+6.0x^1-1.0x^0");
    }
    @Test
    public void integrationTest() {
        Polynomial polynomialP = new Polynomial();
        Regex regex = new Regex();
        polynomialP = regex.createPolynomial("2x^3+3x^2-1x^1");
        polynomialP = polynomialP.integr();
        Assertions.assertEquals(polynomialP.toString(),"+0.5x^4+1.0x^3-0.5x^2");
    }
}
