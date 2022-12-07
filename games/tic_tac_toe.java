package games;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class tic_tac_toe extends JFrame implements ActionListener {

    Container c = new Container();
    GridLayout grid = new GridLayout(3, 3, 3, 3);
    JLabel title = new JLabel("TIC TAC TOE");
    JButton b[] = new JButton[9];
    JButton reset = new JButton("RESET");
    int turn = 0, count = 0, win, num = -1;
    int a[][] = { { -1, -1, -1 }, { -1, -1, -1 }, { -1, -1, -1 } };
    int visited[] = new int[9];
    ImageIcon x_image = new ImageIcon("games/x.png");
    ImageIcon o_image = new ImageIcon("games/o.png");
    Image icon = Toolkit.getDefaultToolkit().getImage("games/x_o_icon.png");

    int evaluate() {
        if (a[0][0] == num && a[0][1] == num && a[0][2] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 0 && i != 1 && i != 2) {
                    b[i].setVisible(false);
                }
            }
            return num;
        } else if (a[0][0] == num && a[1][0] == num && a[2][0] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 0 && i != 3 && i != 6) {
                    b[i].setVisible(false);
                }
            }
            return num;
        } else if (a[2][0] == num && a[2][1] == num && a[2][2] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 6 && i != 7 && i != 8) {
                    b[i].setVisible(false);
                }
            }
            return num;
        } else if (a[0][2] == num && a[1][2] == num && a[2][2] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 2 && i != 5 && i != 8) {
                    b[i].setVisible(false);
                }
            }
            return num;
        } else if (a[0][0] == num && a[1][1] == num && a[2][2] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 0 && i != 4 && i != 8) {
                    b[i].setVisible(false);
                }
            }
            return num;
        } else if (a[0][2] == num && a[1][1] == num && a[2][0] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 2 && i != 4 && i != 6) {
                    b[i].setVisible(false);
                }
            }
            return num;
        } else if (a[1][0] == num && a[1][1] == num && a[1][2] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 3 && i != 4 && i != 5) {
                    b[i].setVisible(false);
                }
            }
            return num;
        } else if (a[0][1] == num && a[1][1] == num && a[2][1] == num) {
            for (int i = 0; i < 9; i++) {
                if (i != 1 && i != 4 && i != 7) {
                    b[i].setVisible(false);
                }
            }
            return num;
        }
        return -1;
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    private void message(String str) {
        JDialog over = new JDialog();
        JLabel l = new JLabel(str);
        l.setBounds(10, 10, 180, 40);
        over.add(l);
        over.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                over.setVisible(false);
                reset.doClick();
            }
        });
        over.setSize(300, 100);
        over.setLayout(null);
        over.setLocationRelativeTo(null);
        over.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reset) {
            for (int i = 0; i < 9; i++) {
                b[i].setIcon(new ImageIcon());
                b[i].setVisible(true);
            }
            for (int j = 0; j < 3; j++) {
                for (int j2 = 0; j2 < 3; j2++) {
                    a[j][j2] = -1;
                }
            }
            for (int i = 0; i < 9; i++) {
                visited[i] = 0;
            }
            win = -1;
            count = 0;
            turn = 0;
            num = -1;
        } else {
            for (int i = 0; i < 9; i++) {
                if (e.getSource() == b[i] && count != 9 && visited[i] != 1) {
                    turn = count % 2;
                    if (turn == 0) {
                        b[i].setIcon(resizeIcon(x_image, b[i].getWidth(), b[i].getHeight()));
                        visited[i] = 1;
                        a[i / 3][i % 3] = 1;
                        num = 1;
                        win = evaluate();
                        if (win == 1) {
                            break;
                        }
                    } else {
                        b[i].setIcon(resizeIcon(o_image, b[i].getWidth(), b[i].getHeight()));
                        visited[i] = 1;
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
                    message("GAME OVER!!! \n Click RESET.");
                    break;
                }
            }
            if (win == 1) {
                message("X-Wins");
                for (int j = 0; j < 3; j++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        a[j][j2] = -1;
                    }
                }
                for (int i = 0; i < 9; i++) {
                    visited[i] = 1;
                }
            } else if (win == 0) {
                message("O-Wins");
                for (int j = 0; j < 3; j++) {
                    for (int j2 = 0; j2 < 3; j2++) {
                        a[j][j2] = -1;
                    }
                }
                for (int i = 0; i < 9; i++) {
                    visited[i] = 1;
                }
            }
        }
    }

    public tic_tac_toe() {
        super("Tic-Tac-Toe");
        this.getContentPane().setBackground(new Color(255, 191, 0));

        for (int i = 0; i < 9; i++) {
            b[i] = new JButton();
            b[i].addActionListener(this);
            b[i].setBackground(Color.gray);
        }

        c.setBounds(20, 100, 500, 500);

        title.setBounds(50, 10, 450, 50);
        title.setFont(new Font("algerian", Font.BOLD, 25));
        title.setHorizontalAlignment(JLabel.CENTER);

        reset.setBounds(20, 80, 80, 20);
        reset.addActionListener(this);

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
        setIconImage(icon);
        setSize(550, 650);
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
