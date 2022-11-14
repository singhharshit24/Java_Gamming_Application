package games;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.util.Arrays;
import java.awt.GridLayout;

public class tic_tac_toe extends JFrame implements ActionListener {

    Container c = new Container();
    GridLayout grid = new GridLayout(3, 3);
    JLabel title = new JLabel("TIC TAC TOE");
    JButton b[] = new JButton[9];
    JButton reset = new JButton("RESET");
    int turn = 0, count = 0, win, num = -1;
    int a[][] = { { -1, -1, -1 }, { -1, -1, -1 }, { -1, -1, -1 } };
    String pic;
    Image img = Toolkit.getDefaultToolkit().getImage("games/x_o_background.png");

    int evaluate() {
        if (a[0][0] == num && a[0][1] == num && a[0][2] == num) {
            return num;
        } else if (a[0][0] == num && a[1][0] == num && a[2][0] == num) {
            return num;
        } else if (a[2][0] == num && a[2][1] == num && a[2][2] == num) {
            return num;
        } else if (a[0][2] == num && a[1][2] == num && a[2][2] == num) {
            return num;
        } else if (a[0][0] == num && a[1][1] == num && a[2][2] == num) {
            return num;
        } else if (a[0][2] == num && a[1][1] == num && a[2][0] == num) {
            return num;
        } else if (a[1][0] == num && a[1][1] == num && a[1][2] == num) {
            return num;
        } else if (a[0][1] == num && a[1][1] == num && a[2][1] == num) {
            return num;
        }
        return -1;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            for (int i = 0; i < 9; i++) {
                b[i].setIcon(new ImageIcon());
                b[i].setEnabled(true);
            }
            for (int j = 0; j < 3; j++) {
                for (int j2 = 0; j2 < 3; j2++) {
                    a[j][j2] = -1;
                }
            }
            win = -1;
            count = 0;
            turn = 0;
            num = -1;
        } else {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == b[i] && count != 9) {
                    turn = count % 2;
                    if (turn == 0) {
                        b[i].setIcon(new ImageIcon("games/x.png"));
                        b[i].setEnabled(false);
                        a[i / 3][i % 3] = 1;
                        num = 1;
                        win = evaluate();
                        if (win == 1) {
                            break;
                        }
                    } else {
                        b[i].setIcon(new ImageIcon("games/o.png"));
                        b[i].setEnabled(false);
                        a[i / 3][i % 3] = 0;
                        num = 0;
                        win = evaluate();
                        if (win == 0) {
                            break;
                        }
                    }
                    count++;
                }
                if (count == 9) {
                    JDialog over = new JDialog();
                    JLabel l = new JLabel("GAME OVER!!! \n Click RESET.");
                    l.setBounds(10, 10, 180, 40);
                    over.add(l);
                    over.addWindowListener(new WindowAdapter() {
                        public void windowClosing(WindowEvent w) {
                            over.setVisible(false);
                        }
                    });
                    over.setSize(300, 200);
                    over.setLayout(null);
                    over.setVisible(true);
                    reset.doClick();
                    count = 0;
                    turn = 0;
                    num = -1;
                    for (int j = 0; j < 3; j++) {
                        for (int j2 = 0; j2 < 3; j2++) {
                            a[j][j2] = -1;
                        }
                    }
                    break;
                }
            }
            if (win == 1) {
                JDialog winner = new JDialog();
                JLabel l = new JLabel("X-wins");
                l.setBounds(10, 10, 180, 20);
                winner.add(l);
                winner.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent w) {
                        winner.setVisible(false);
                        reset.doClick();
                    }
                });
                winner.setSize(300, 200);
                winner.setLayout(null);
                winner.setVisible(true);
                count = 0;
                win = -1;
                turn = 0;
                num = -1;
                for (int j = 0; j < 3; j++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        a[j][j2] = -1;
                    }
                }
            } else if (win == 0) {
                JDialog winner = new JDialog();
                JLabel l = new JLabel("O-wins");
                l.setBounds(10, 10, 180, 20);
                winner.add(l);
                winner.addWindowListener(new WindowAdapter() {
                    public void windowClosing(WindowEvent w) {
                        winner.setVisible(false);
                        reset.doClick();
                    }
                });
                winner.setSize(300, 200);
                winner.setLayout(null);
                winner.setVisible(true);
                count = 0;
                win = -1;
                turn = 0;
                num = -1;
                for (int j = 0; j < 3; j++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        a[j][j2] = -1;
                    }
                }
            }
        }
    }

    public tic_tac_toe() {
        super("Tic-Tac-Toe");

        for (int i = 0; i < 9; i++) {
            b[i] = new JButton();
            b[i].addActionListener(this);
        }

        c.setBounds(20, 100, 500, 500);

        title.setBounds(50, 10, 300, 50);
        title.setFont(new Font("arial", Font.BOLD, 25));

        reset.setBounds(20, 80, 80, 20);
        reset.addActionListener(this);

        // this.setContentPane(new JPanel() {
        // @Override
        // public void paintComponent(Graphics g) {
        // super.paintComponent(g);
        // g.drawImage(img, 0, 0, null);
        // }
        // });
        for (int i = 0; i < 9; i++) {
            c.add(b[i]);
        }
        add(c);
        add(title);
        add(reset);

        c.setLayout(grid);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                setVisible(false);
            }
        });
        setSize(550, 650);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }
}
