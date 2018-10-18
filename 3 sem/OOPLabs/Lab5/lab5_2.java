package OOPLabs.Lab5;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class lab5_2 {
    public static void main(String[] args) throws  Exception{
        new lab5_2(args[0]);
    }

    public lab5_2(final String filename) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("ImageDisplay");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                BufferedImage image = null;
                try {
                    image = ImageIO.read(new File(filename));

                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(1);
                }
                ImageIcon imageIcon = new ImageIcon(image);
                JLabel jLabel = new JLabel();
                jLabel.setIcon(imageIcon);
                frame.getContentPane().add(jLabel, BorderLayout.CENTER);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

