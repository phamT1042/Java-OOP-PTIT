package B4;

/**
 *
 * @author admin
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class Calculator extends JFrame implements ActionListener {
    private static JTextField displayBox;

    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");

    private JButton buttonPlus = new JButton("+");
    private JButton buttonMinus = new JButton("-");
    private JButton buttonDivide = new JButton("/");
    private JButton buttonMultiply = new JButton("*");
    private JButton buttonClear = new JButton("C");
    private JButton buttonSqrt = new JButton("√");
    private JButton buttonEquals = new JButton("=");
    private JButton buttonPow = new JButton("Lũy thừa");

    public Calculator(String title) throws HeadlessException {
        super(title);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 450);
        setResizable(false);
        setLocationRelativeTo(null);

        JPanel show = new JPanel();     
        displayBox = new JTextField(22);
        displayBox.setPreferredSize(new Dimension(20, 60));
        displayBox.setEditable(false);
        show.add(displayBox);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);
        button9.addActionListener(this);
        button0.addActionListener(this);

        buttonPlus.addActionListener(this);
        buttonMinus.addActionListener(this);
        buttonDivide.addActionListener(this);
        buttonMultiply.addActionListener(this);
        buttonClear.addActionListener(this);
        buttonSqrt.addActionListener(this);
        buttonEquals.addActionListener(this);
        buttonPow.addActionListener(this);

        JPanel r1 = new JPanel();
        r1.setLayout(new GridLayout(4, 4));
        r1.add(button1);
        r1.add(button2);
        r1.add(button3);
        r1.add(buttonPlus);
        r1.add(button4);
        r1.add(button5);
        r1.add(button6);
        r1.add(buttonMinus);
        r1.add(button7);
        r1.add(button8);
        r1.add(button9);
        r1.add(buttonDivide);
        r1.add(buttonSqrt);
        r1.add(button0);
        r1.add(buttonClear);
        r1.add(buttonMultiply);

        JPanel r2 = new JPanel();
        r2.setLayout(new GridLayout(1, 2));
        r2.add(buttonPow);
        r2.add(buttonEquals);

        add(show, BorderLayout.NORTH);
        add(r1, BorderLayout.CENTER);
        add(r2, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonClear)
            displayBox.setText("");
        else if (e.getSource() == buttonEquals)
            displayBox.setText(calculate(displayBox.getText()));
        else if (e.getSource() == buttonSqrt) {
            try {
                double result = Math.sqrt(Integer.parseInt(displayBox.getText().trim()));
                if (String.valueOf(result).equals("NaN"))
                    displayBox.setText("MATH ERROR!");
                else
                    displayBox.setText(String.valueOf(result));
            }
            catch (Exception ex) {
                displayBox.setText("MATH ERROR!");
            }
        }
        else if (e.getSource() == buttonPow)
            displayBox.setText(displayBox.getText() + "^");
        else
            displayBox.setText(displayBox.getText() + e.getActionCommand());
    }

    private int degree(char c) {
        if (c == '^') return 3;
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }

    private double calc(double a, double b, char c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '^':
                return Math.pow(a, b);
            default:
                return 0.0;
        }
    }

    private String calculate(String s) {
        try {
            Stack<Double> res = new Stack<>();
            Stack<Character> trungTo = new Stack<>();
            double val, val1, val2;
            char top;
            res.push((double) 0);
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    val = 0;
                    while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                        val = val * 10 + s.charAt(i) - '0';
                        ++i;
                    }
                    res.push(val);
                    --i;
                }
                else {
                    while (!trungTo.isEmpty() && degree(trungTo.peek()) >= degree(s.charAt(i))) {
                        val2 = res.peek();
                        res.pop();
                        val1 = res.peek();
                        res.pop();
                        top = trungTo.peek();
                        trungTo.pop();
                        res.push(calc(val1, val2, top));
                    }
                    trungTo.push(s.charAt(i));
                }
            }
            while (!trungTo.isEmpty()) {
                val2 = res.peek();
                res.pop();
                val1 = res.peek();
                res.pop();
                top = trungTo.peek();
                trungTo.pop();
                res.push(calc(val1, val2, top));
            }
            double result = res.peek();
            if (result == (long) result)
                return String.valueOf((long) result);
            return String.valueOf(res.peek());
        }
        catch (Exception e) {
            return "MATH ERROR!";
        }
    }
}
