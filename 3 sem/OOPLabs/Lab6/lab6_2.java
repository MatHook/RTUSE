package OOPLabs.Lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class lab6_2 {
    public static void main(String[] args) {
        new Frame6_2();
    }
}

class Frame6_2 extends JFrame {
    HashMap<JLabel, String> notes;

    Frame6_2() {
        super("Lab6_2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        JLabel center = new JLabel("Center", JLabel.CENTER);
        JLabel west = new JLabel("West", JLabel.CENTER);
        JLabel east = new JLabel("East", JLabel.CENTER);
        JLabel north = new JLabel("North", JLabel.CENTER);
        JLabel south = new JLabel("South", JLabel.CENTER);

        notes = new HashMap<JLabel, String>();

        notes.put(center, "Welcome to Center");
        notes.put(west, "Welcome to West");
        notes.put(east, "Welcome to East");
        notes.put(north, "Welcome to North");
        notes.put(south, "Welcome to South");

        MAdapter adapter = new MAdapter(this);

        center.addMouseListener(adapter);
        west.addMouseListener(adapter);
        east.addMouseListener(adapter);
        north.addMouseListener(adapter);
        south.addMouseListener(adapter);

        add(center, BorderLayout.CENTER);
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);
        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);

        setVisible(true);
    }
}

class MAdapter extends MouseAdapter {
    Frame6_2 frame6_2;

    public MAdapter(Frame6_2 frame6_2) {
        super();

        this.frame6_2 = frame6_2;
    }

    public void mouseEntered(MouseEvent e) {
        if (!frame6_2.notes.containsKey(e.getSource())) {
            return;
        }
        JOptionPane.showMessageDialog(null, frame6_2.notes.get(e.getSource()));
    }
}