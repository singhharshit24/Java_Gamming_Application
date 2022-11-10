package games;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.GridLayout;

public class tic_tac_toe {
    public tic_tac_toe() {
        JFrame f = new JFrame("Tic-Tac-Toe");
        Container c = new Container();
        GridLayout grid = new GridLayout(3, 3);
        JLabel title = new JLabel("TIC TAC TOE");
        JButton b[] = new JButton[9];
        JButton reset = new JButton("RESET");
        for (int i = 0; i < 9; i++) {
            b[i] = new JButton();
        }
        b[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b[0].setIcon(new ImageIcon("games/x.png"));
            }
        });

        b[0].setBackground(Color.white);
        
        c.setBounds(20, 100, 500, 500);
        
        title.setBounds(50, 10, 300, 50);
        title.setFont(new Font("arial", Font.BOLD, 25));
        
        reset.setBounds(20, 80, 80, 20);
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 9; i++) {
                    b[i].setIcon(new ImageIcon());
                }
            }
        });

        for (int i = 0; i < 9; i++) {
            c.add(b[i]);
        }
        f.add(c);
        f.add(title);
        f.add(reset);

        c.setLayout(grid);

        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                f.setVisible(false);
            }
        });
        f.setSize(550, 650);
        f.setLayout(null);
        f.setResizable(false);
        f.setVisible(true);
    }
}
