package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JLabel firstPolynomial = new JLabel("model.Polynomial P(x): ");
    private JLabel secondPolynomial = new JLabel("model.Polynomial Q(x): ");
    private JLabel result = new JLabel("Result: ");

    private JTextField inputFirstPolynomial = new JTextField(30);
    private JTextField inputSecondPolynomial = new JTextField(30);

    private JTextArea output = new JTextArea(2, 40);

    private JButton addition = new JButton("Addition");
    private JButton subtraction = new JButton("Subtraction");
    private JButton multiplication = new JButton("Multiplication");
    private JButton division = new JButton("Division");
    private JButton derivative = new JButton("Derivation(1st polynomial)");
    private JButton integration = new JButton("Integration(1st polynomial)");

    public View() {

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // input user zone
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(firstPolynomial);
        inputPanel.add(inputFirstPolynomial);
        inputPanel.add(secondPolynomial);
        inputPanel.add(inputSecondPolynomial);

        // button panel zone
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 3));
        buttonPanel.add(addition);
        buttonPanel.add(subtraction);
        buttonPanel.add(multiplication);
        buttonPanel.add(division);
        buttonPanel.add(derivative);
        buttonPanel.add(integration);

        // print result zone
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());
        resultPanel.add(result);
        resultPanel.add(output);

        mainPanel.add(inputPanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(resultPanel);

        output.setEditable(false);
        this.setPreferredSize(new Dimension(600, 300));
        this.setContentPane(mainPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("model.Polynomial Calculator");

    }

    public String getInputFirstPolynomial() {
        return inputFirstPolynomial.getText();
    }

    public String getInputSecondPolynomial() {
        return inputSecondPolynomial.getText();
    }

    public void setOutput(String outputText) {
        output.setText(outputText);
    }

    // add action listeners for buttons
    public void addListener(ActionListener e) {
        this.addition.addActionListener(e);
    }

    public void subListener(ActionListener e) {
        this.subtraction.addActionListener(e);
    }

    public void mulListener(ActionListener e) {
        this.multiplication.addActionListener(e);
    }
    public void derListener (ActionListener e){
        this.derivative.addActionListener(e);
    }
    public void integrListener (ActionListener e){
        this.integration.addActionListener(e);
    }

    /* Not implemented
    public void divListener(ActionListener e) {
        this.division.addActionListener(e);
    }
     */
        public void showError (String msg){
            JOptionPane.showMessageDialog(this, "Empty polynomials/wrong format!");
        }
    }

