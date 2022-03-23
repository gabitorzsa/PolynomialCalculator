package controller;

import model.Polynomial;
import view.View;

import java.awt.event.*;

public class Controller {

    private View v;
    private Polynomial m;

    public Controller(Polynomial m, View v) {
        this.m = m;
        this.v = v;
        this.v.addListener(new ListenerAdd());
        this.v.subListener(new ListenerSub());
        this.v.mulListener(new ListenerMul());
        //this.v.divListener(new ListenerMul());  // Not implemented
        this.v.derListener(new ListenerDer());
        this.v.integrListener(new ListenerIntegr());
    }

    class ListenerAdd implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Regex regex = new Regex();
                Polynomial P = new Polynomial();
                P = regex.createPolynomial(v.getInputFirstPolynomial());
                Polynomial Q = new Polynomial();
                Q = regex.createPolynomial(v.getInputSecondPolynomial());
                v.setOutput(P.add(Q).toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }

    class ListenerSub implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Regex regex = new Regex();
                Polynomial P = new Polynomial();
                P = regex.createPolynomial(v.getInputFirstPolynomial());
                Polynomial Q = new Polynomial();
                Q = regex.createPolynomial(v.getInputSecondPolynomial());
                v.setOutput(P.sub(Q).toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }

    class ListenerMul implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Regex regex = new Regex();
                Polynomial P = new Polynomial();
                P = regex.createPolynomial(v.getInputFirstPolynomial());
                Polynomial Q = new Polynomial();
                Q = regex.createPolynomial(v.getInputSecondPolynomial());
                v.setOutput(P.mul(Q).toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }

    class ListenerDer implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Regex regex = new Regex();
                Polynomial P = new Polynomial();
                P = regex.createPolynomial(v.getInputFirstPolynomial());
                Polynomial Q = new Polynomial();
                Q = regex.createPolynomial(v.getInputSecondPolynomial());
                v.setOutput(P.der().toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }
    class ListenerIntegr implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Regex regex = new Regex();
                Polynomial P = new Polynomial();
                P = regex.createPolynomial(v.getInputFirstPolynomial());
                Polynomial Q = new Polynomial();
                Q = regex.createPolynomial(v.getInputSecondPolynomial());
                v.setOutput(P.integr().toString());
            } catch (Exception ex) {
                v.showError(ex.getMessage());
            }
        }
    }
}
