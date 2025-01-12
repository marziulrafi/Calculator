import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;

    private double num1, num2, result;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        textField = new JTextField();
        textField.setBounds(10, 10, 265, 40);
        textField.setFont(new Font("Arial", Font.PLAIN, 18));
        textField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        JButton[] functionButtons = {addButton, subButton, mulButton, divButton, eqButton, clrButton};

        for (JButton button : functionButtons) {
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(this);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            numberButtons[i].addActionListener(this);
        }

        int buttonWidth = 50;
        int buttonHeight = 50;
        int x = 10;
        int y = 60;

        for (int i=1; i<=9; i++) {
            numberButtons[i].setBounds(x, y, buttonWidth, buttonHeight);
            x += buttonWidth + 10;
            if (i%3==0) {
                x=10;
                y+=buttonHeight+10;
            }
        }

        numberButtons[0].setBounds(10, y, buttonWidth, buttonHeight);
        addButton.setBounds(10, y+buttonHeight+10, buttonWidth, buttonHeight);
        subButton.setBounds(70, y+buttonHeight+10, buttonWidth, buttonHeight);
        mulButton.setBounds(130, y+buttonHeight+10, buttonWidth, buttonHeight);
        divButton.setBounds(190, y+buttonHeight+10, buttonWidth, buttonHeight);
        eqButton.setBounds(250, y+buttonHeight+10, buttonWidth, buttonHeight);
        clrButton.setBounds(250, 60, buttonWidth, buttonHeight);

        add(textField);
        for (JButton button : numberButtons) {
            add(button);
        }
        add(addButton);
        add(subButton);
        add(mulButton);
        add(divButton);
        add(eqButton);
        add(clrButton);

        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
        }
    }
}