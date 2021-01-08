/*
Zuzanna Liberto
11/16/2018
 */

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App1 extends JFrame implements ActionListener {
    JPanel mpanel, upanel, lpanel;
    JTextField tf1, tf2, tf3;
    JButton jb1, jb2, jb3, jb4, jb5, jb6;
    JLabel jl1, jl2, jl3;
    int r = 0, g = 0, b = 0;

    public static void main(String[] args) {
        App1 object = new App1();
        object.colorLowerPanel();

    }

    App1() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("App1");
        this.setSize(750, 500);
        mpanel = new JPanel();
        this.add(mpanel);
        mpanel.setLayout(new GridLayout(2, 1));

        upanel = new JPanel();
        mpanel.add(upanel);
        lpanel = new JPanel();
        mpanel.add(lpanel);

        jl1 = new JLabel("R");
        upanel.add(jl1);
        tf1 = new JTextField("0", 3);
        upanel.add(tf1);
        tf1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                r = Integer.parseInt(tf1.getText());
                if (r < 0 || r > 255) {
                    r = 0;
                    colorLowerPanel();
                } else
                    colorLowerPanel();
            }


            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        jb1 = new JButton("+");
        upanel.add(jb1);
        jb1.addActionListener(this);
        jb2 = new JButton("-");
        upanel.add(jb2);
        jb2.addActionListener(this);
        upanel.add(Box.createHorizontalStrut(10));

        jl2 = new JLabel("G");
        upanel.add(jl2);
        tf2 = new JTextField("0", 3);
        upanel.add(tf2);
        tf2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                g = Integer.parseInt(tf2.getText());
                if (g < 0 || g > 255) {
                    g = 0;
                    colorLowerPanel();
                } else
                    colorLowerPanel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        jb3 = new JButton("+");
        upanel.add(jb3);
        jb3.addActionListener(this);
        jb4 = new JButton("-");
        upanel.add(jb4);
        jb4.addActionListener(this);
        upanel.add(Box.createHorizontalStrut(10));

        jl3 = new JLabel("B");
        upanel.add(jl3);
        tf3 = new JTextField("0", 3);
        upanel.add(tf3);
        tf3.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                b = Integer.parseInt(tf3.getText());
                if (b < 0 || b > 255) {
                    b = 0;
                    colorLowerPanel();
                } else
                    colorLowerPanel();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        jb5 = new JButton("+");
        upanel.add(jb5);
        jb5.addActionListener(this);

        jb6 = new JButton("-");
        upanel.add(jb6);
        jb6.addActionListener(this);

        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == tf1)
            typeInput(tf1, r);

        if (e.getSource() == jb1)
            plusOne(tf1, r);

        if (e.getSource() == jb2)
            minusOne(tf1, r);

        if (e.getSource() == tf2)
            typeInput(tf2, g);

        if (e.getSource() == jb3)
            plusOne(tf2, g);

        if (e.getSource() == jb4)
            minusOne(tf2, g);

        if (e.getSource() == tf3)
            typeInput(tf3, b);

        if (e.getSource() == jb5)
            plusOne(tf3, b);

        if (e.getSource() == jb6)
            minusOne(tf3, b);

    }

    void colorLowerPanel() {

        Color bcolor = new Color(r, g, b);
        lpanel.setBackground(bcolor);
        lpanel.repaint();
    }


    void minusOne(JTextField field, int colorValue) {
        String inputString = field.getText();
        colorValue = Integer.valueOf(inputString);
        if (colorValue >= 1) {
            colorValue--;
            inputString = Integer.toString(colorValue);
            field.setText(inputString);
        }

    }

    void plusOne(JTextField field, int colorValue) {
        String inputString = field.getText();
        colorValue = Integer.valueOf(inputString);
        if (colorValue <= 254) {
            colorValue++;
            inputString = Integer.toString(colorValue);
            field.setText(inputString);
        }
    }

    void typeInput(JTextField field, int colorValue) {
        String input = field.getText();
        colorValue = Integer.parseInt(input);
    }

}