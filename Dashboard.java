import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import games.*;
import music.*;

public class Dashboard {

    public static void main(String[] args) {
        JFrame f = new JFrame("Alpha Games");
        GridLayout grid = new GridLayout(1, 3, 10, 1);
        JLabel title = new JLabel("Welcome To the Alpha Games!");
        Font title_font = new Font("arial", Font.BOLD, 25);
        JButton b1 = new JButton();
        JButton b2 = new JButton();
        JButton b3 = new JButton();
        ImageIcon p2 = new ImageIcon("15_puzzle.png");
        ImageIcon p3 = new ImageIcon("maze.png");

        Image icon = Toolkit.getDefaultToolkit().getImage("icon.png");

        Container c = new Container();
        c.setBounds(20, 130, 600, 190);
        c.setLayout(grid);

        Music m = new Music();
        m.setFile("night-run-125181.wav");
        m.play();

        title.setBounds(120, 20, 400, 80);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(title_font);
        title.setForeground(new Color(255, 255, 240));

        b1.setIcon(new ImageIcon("tic-tac-toe.png"));
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new tic_tac_toe();
            }
        });

        b2.setIcon(p2);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new puzzle();
            }
        });

        b3.setIcon(p3);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new maze();
            }
        });

        c.add(b1);
        c.add(b2);
        c.add(b3);

        f.add(c);
        f.add(title);

        f.setIconImage(icon);
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
        f.setSize(653, 500);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}