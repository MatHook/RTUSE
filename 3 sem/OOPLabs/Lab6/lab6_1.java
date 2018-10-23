package OOPLabs.Lab6;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Random;

public class lab6_1 {
    public static void main(String[] args) {
        new Frame();
    }
}
class Frame extends JFrame {
    Frame() {
        JFrame f = new JFrame(" Lab6_1");
        JButton b = new JButton("Submit");
        b.setBounds(100, 100, 140, 40);
        JLabel label = new JLabel();
        label.setText("Enter number :");
        label.setBounds(10, 10, 100, 100);
        JLabel label1 = new JLabel();
        label1.setBounds(100, 110, 200, 100);
        JTextField textfield = new JTextField();
        textfield.setBounds(110, 50, 100, 25);
        f.add(label1);
        f.add(textfield);
        f.add(label);
        f.add(b);
        f.setSize(300, 300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Random rnd = new Random();
        int random_int = rnd.nextInt(20);
        final int[] summ = {0};

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                int user_int = Integer.parseInt(textfield.getText());
                if (user_int == random_int) {
                    label1.setText("You win!");
                }
                else if (user_int > random_int) {
                    label1.setText("Your number bigger than computer's number");
                }
                else if (user_int < random_int) {
                    label1.setText("Your number less than computer's number");
                }
                summ[0] += 1;
                if (summ[0] == 3) {
                    f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
                }
        };
    });
}
}
