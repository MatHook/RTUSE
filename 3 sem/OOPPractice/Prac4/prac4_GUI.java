package OOPPractice.Prac4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class prac4_GUI extends JFrame implements ActionListener {
    int score_Milan = 0;
    int score_RM = 0;

    JLabel label1 = new JLabel("Result: 0 : 0");
    JLabel label2 = new JLabel("Winner: DRAW");
    JLabel label3 = new JLabel("Last scorer: N/A");
    JButton button1 = new JButton("AC Milan");
    JButton button2 = new JButton("Real Madrid");

    public static void main(String[]args) {
        new prac4_GUI();
    }

    prac4_GUI() {
        super("Score counter");

        setSize(480, 480);
        setFont(null);

        GridBagConstraints c = new GridBagConstraints();

        setLayout(new GridBagLayout());

        c.gridx = 0;
        c.gridwidth = 2;

        c.gridy = 0;
        add(label1, c);

        c.gridy = 1;
        add(label3, c);

        c.gridy = 2;
        add(label2, c);

        c.gridwidth = 1;

        c.gridy = 3;
        add(button1, c);
        button1.addActionListener(this);

        c.gridx = 1;
        add(button2, c);
        button2.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JButton button = (JButton) ae.getSource();

        label3.setText(String.format(
                "Last scorer: %s", button.getText()));

        if (button.getText().equals("Real Madrid")) {
            score_RM += 1;
        } else {
            score_Milan += 1;
        }

        label1.setText(
                String.format("Result: %d : %d", score_Milan, score_RM)
        );

        if (score_RM > score_Milan) {
            label2.setText("Winner: Real Madrid");
        } else if (score_RM < score_Milan) {
            label2.setText("Winner: AC Milan");
        } else {
            label2.setText("Winner: draw");
        }
    }
}