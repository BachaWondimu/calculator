package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    JTextField operandTF;

    JButton[] nums = new JButton[10];
    JButton[] oper;
    JButton add, sub, mult, div, equals, neg, del, dec, module, clear;
    char operator;
    double num1, num2;
    double result = 0;


    JPanel panel;


    Calculator() {
        operandTF = new JTextField();
        operandTF.setBounds(50, 70, 400, 80);
        operandTF.setBackground(Color.WHITE);
        operandTF.setEditable(false);


        //Buttons
        for (int i = 0; i < 10; i++) {
            nums[i] = new JButton("" + i);
            nums[i].addActionListener(this);
            nums[i].setFocusable(false);
        }


        add = new JButton("+");
        sub = new JButton("-");
        mult = new JButton("*");
        div = new JButton("/");
        dec = new JButton(".");
        equals = new JButton("=");
        neg = new JButton("(-)");
        del = new JButton("Delete");
        module = new JButton("%");
        clear = new JButton("Clear");

        oper = new JButton[]{del, clear, module, add, sub, mult, div, dec, equals, neg};
        for (int i = 0; i < 10; i++) {
            oper[i].addActionListener(this);
        }




       /*
       Fill the panel
        */
        panel = new JPanel();
        panel.setBackground(Color.CYAN);
        panel.setBounds(50, 150, 400, 400);
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        for (int i = 0; i < 4; i++) {
            panel.add(oper[i]);
        }
        panel.add(div);
        for (int i = 7; i < 10; i++) {
            panel.add(nums[i]);
        }
        panel.add(mult);
        for (int i = 4; i < 7; i++) {
            panel.add(nums[i]);
        }
        panel.add(sub);
        for (int i = 1; i < 4; i++) {
            panel.add(nums[i]);
        }
        panel.add(add);
        panel.add(neg);
        panel.add(nums[0]);
        panel.add(dec);
        panel.add(equals);


        //JFrame Components
        add(panel);
        add(operandTF);

        //JFrame
        setTitle("Calculator By Bacha");
        setSize(550, 650);
        setLayout(null);
        setVisible(true);
        setFocusable(false);
        setBackground(Color.BLUE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i < 10; i++) {
            if (e.getSource() == nums[i]) {
                String str = operandTF.getText();
                if (str.isEmpty() || str.equals("0"))
                    operandTF.setText("" + i);
                else {
                    if (Double.parseDouble(operandTF.getText()) == result)
                        operandTF.setText("" + i);
                    else
                        operandTF.setText(str + i);
                }
            }
        }

        if (e.getSource() == nums[0]) {
            String str = operandTF.getText();
            if (str.isEmpty())
                operandTF.setText("0");
            else if (!str.equals("0")) {
                if (Double.parseDouble(operandTF.getText()) == result)
                    operandTF.setText("0");
                else
                    operandTF.setText(operandTF.getText() + "0");
            }
        }

        if (e.getSource() == dec) {
            String str = operandTF.getText();
            if (str.equals(""))
                operandTF.setText("0.");
            else if (!str.contains("."))
                operandTF.setText(str + ".");
        }

        if (e.getSource() == neg) {
            String str = operandTF.getText();
            if (!str.equals("")) {
                double d = Double.parseDouble(str);
                d = -1 * d;
                operandTF.setText("" + d);
            }
        }

        if (e.getSource() == del) {
            String str = operandTF.getText();
            if (!str.equals("")) {
                str = str.substring(0, str.length() - 1);
                operandTF.setText(str);
            }
        }

        if (e.getSource() == clear) {
            operandTF.setText("");
        }


        if (e.getSource() == module) {
            String str = operandTF.getText();
            if (!str.equals("")) {
                num1 = Double.parseDouble(str);
                operator = '%';
                operandTF.setText("");
            }
        }


        if (e.getSource() == div) {
            String str = operandTF.getText();
            if (!str.equals("")) {
                num1 = Double.parseDouble(str);
                operator = '/';
                operandTF.setText("");
            }
        }

        if (e.getSource() == mult) {
            String str = operandTF.getText();
            if (!str.equals("")) {
                num1 = Double.parseDouble(str);
                operator = '*';
                operandTF.setText("");
            }
        }

        if (e.getSource() == sub) {
            String str = operandTF.getText();
            if (!str.equals("")) {
                num1 = Double.parseDouble(str);
                operator = '-';
                operandTF.setText("");
            }
        }

        if (e.getSource() == add) {
            String str = operandTF.getText();
            if (!str.equals("")) {
                num1 = Double.parseDouble(str);
                operator = '+';
                operandTF.setText("");
            }
        }


        if (e.getSource() == equals) {
            String str = operandTF.getText();
            result = num1;
            if (!str.equals("")) {
                num2 = Double.parseDouble(str);
                switch (operator) {
                    case '%':
                        result = num1 % num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '+':
                        result = num1 + num2;
                        break;
                }
                num1 = result;
                operandTF.setText("" + result);
            }
        }

    }
}

