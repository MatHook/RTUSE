package OOPLabs.Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class lab6_3 extends JFrame implements ActionListener {
    private final JTextArea textArea;
    private final JComboBox<String> colorBox;
    private final JComboBox<String> fontBox;

    public static void main(String[] args) {
        new lab6_3();
    }
    private lab6_3() {
        super("Lab6_3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea("", 20, 50);
        colorBox = new JComboBox<>(new String[] {"Blue", "Red", "Black"});
        fontBox = new JComboBox<>(new String[] {"Times New Roman", "MS Sans Serif", "Courier New"});

        colorBox.addActionListener(this);
        fontBox.addActionListener(this);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(textArea);
        add(colorBox);
        add(fontBox);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(fontBox)) {
            textArea.setFont(
                    new Font(
                            (String) fontBox.getSelectedItem(),
                            Font.PLAIN,
                            16
                    ));
        }
        else {
            Color cset = Color.GREEN;

            switch ((String) Objects.requireNonNull(colorBox.getSelectedItem())) {
                case "Blue" : cset = Color.BLUE;
                break;
                case "Red" : cset = Color.RED;
                break;
                case "Black" : cset = Color.BLACK;
                break;
            }

            textArea.setForeground(cset);
        }
    }
}
