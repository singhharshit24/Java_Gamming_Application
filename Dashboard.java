import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

import games.*;
import music.*;

public class Dashboard {
    public static void main(String[] args) {
        JFrame f = new JFrame("Mini Games");
        JLabel title = new JLabel("Welcome To the MiniGames!");
        Font title_font = new Font("arial", Font.BOLD, 25);
        JButton b1 = new JButton();
        Music m = new Music();
        m.setFile("sweet-love-121561.wav");
        m.play();

        title.setBounds(120, 20, 400, 80);
        title.setFont(title_font);
        title.setForeground(Color.white);

        b1.setIcon(new ImageIcon("tic-tac-toe.png"));
        b1.setBounds(40, 130, 200, 200);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tic_tac_toe t = new tic_tac_toe();
            }
        });

        f.add(title);
        f.add(b1);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                try {
                    m.stop();
                } catch (Exception e) {
                    // TODO: handle exception
                }
                System.exit(0);
            }
        });
        f.getContentPane().setBackground(new Color(90, 90, 90));
        f.setSize(600, 500);
        f.setLayout(null);
        f.setVisible(true);
    }
}