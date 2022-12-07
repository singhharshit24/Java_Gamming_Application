package games;

import java.util.Random;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class puzzle extends JFrame implements ActionListener {
    JButton next;
    JButton b[] = new JButton[16];
    GridLayout grid = new GridLayout(4, 4, 2, 2);
    Container cont = new Container();
    Image icon = Toolkit.getDefaultToolkit().getImage("games/15_puzzle_icon.png");

    public puzzle() {
        next = new JButton("NEXT");
        next.setBounds(85, 350, 100, 50);
        next.addActionListener(this);
        cont.setBounds(10, 30, 250, 300);
        cont.setLayout(grid);
        for (int i = 0; i < 16; i++) {
            b[i] = new JButton();
            cont.add(b[i]);
            b[i].addActionListener(this);
        }
        add(cont);
        add(next);
        setTitle("15 Puzzle game");
        this.setIconImage(icon);
        getContentPane().setBackground(new Color(255, 204, 0));
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setSize(285, 450);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                setVisible(false);
            }
        });
        setResizable(false);
        restart();
    }

    public void restart() {
        Font f = new Font("arial", Font.PLAIN, 18);
        Random r = new Random();
        int randomNumberOrigin = 1;
        int randomNumberBound = 16;
        int size = 15;
        int[] unique = r.ints(randomNumberOrigin, randomNumberBound)
                .distinct()
                .limit(size)
                .toArray();
        for (int i = 0; i < 15; i++) {
            b[i].setText(Integer.toString(unique[i]));
            b[i].setFont(f);
        }
        b[15].setFont(f);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b[0]) {
            String s = b[0].getText();
            if (b[1].getText().equals("")) {
                b[1].setText(s);
                b[0].setText("");
            } else if (b[4].getText().equals("")) {
                b[4].setText(s);
                b[0].setText("");
            }
        }
        if (e.getSource() == b[3]) {
            String s = b[3].getText();
            if (b[2].getText().equals("")) {
                b[2].setText(s);
                b[3].setText("");
            } else if (b[7].getText().equals("")) {
                b[7].setText(s);
                b[3].setText("");
            }
        }
        if (e.getSource() == b[12]) {
            String s = b[12].getText();
            if (b[8].getText().equals("")) {
                b[8].setText(s);
                b[12].setText("");
            } else if (b[13].getText().equals("")) {
                b[13].setText(s);
                b[12].setText("");
            }
        }
        if (e.getSource() == b[15]) {
            String s = b[15].getText();
            if (b[14].getText().equals("")) {
                b[14].setText(s);
                b[15].setText("");
            } else if (b[11].getText().equals("")) {
                b[11].setText(s);
                b[15].setText("");
            }
        }
        if (e.getSource() == b[1]) {
            String s = b[1].getText();
            if (b[0].getText().equals("")) {
                b[0].setText(s);
                b[1].setText("");
            } else if (b[2].getText().equals("")) {
                b[2].setText(s);
                b[1].setText("");
            } else if (b[5].getText().equals("")) {
                b[5].setText(s);
                b[1].setText("");
            }
        }
        if (e.getSource() == b[2]) {
            String s = b[2].getText();
            if (b[1].getText().equals("")) {
                b[1].setText(s);
                b[2].setText("");
            } else if (b[3].getText().equals("")) {
                b[3].setText(s);
                b[2].setText("");
            } else if (b[6].getText().equals("")) {
                b[6].setText(s);
                b[2].setText("");
            }
        }
        if (e.getSource() == b[4]) {
            String s = b[4].getText();
            if (b[0].getText().equals("")) {
                b[0].setText(s);
                b[4].setText("");
            } else if (b[5].getText().equals("")) {
                b[5].setText(s);
                b[4].setText("");
            } else if (b[8].getText().equals("")) {
                b[8].setText(s);
                b[4].setText("");
            }
        }
        if (e.getSource() == b[7]) {
            String s = b[7].getText();
            if (b[3].getText().equals("")) {
                b[3].setText(s);
                b[7].setText("");
            } else if (b[6].getText().equals("")) {
                b[6].setText(s);
                b[7].setText("");
            } else if (b[11].getText().equals("")) {
                b[11].setText(s);
                b[7].setText("");
            }
        }
        if (e.getSource() == b[8]) {
            String s = b[8].getText();
            if (b[9].getText().equals("")) {
                b[9].setText(s);
                b[8].setText("");
            } else if (b[4].getText().equals("")) {
                b[4].setText(s);
                b[8].setText("");
            } else if (b[12].getText().equals("")) {
                b[12].setText(s);
                b[8].setText("");
            }
        }
        if (e.getSource() == b[11]) {
            String s = b[11].getText();
            if (b[10].getText().equals("")) {
                b[10].setText(s);
                b[11].setText("");
            } else if (b[15].getText().equals("")) {
                b[15].setText(s);
                b[11].setText("");
            } else if (b[7].getText().equals("")) {
                b[7].setText(s);
                b[11].setText("");
            }
        }
        if (e.getSource() == b[13]) {
            String s = b[13].getText();
            if (b[14].getText().equals("")) {
                b[14].setText(s);
                b[13].setText("");
            } else if (b[12].getText().equals("")) {
                b[12].setText(s);
                b[13].setText("");
            } else if (b[9].getText().equals("")) {
                b[9].setText(s);
                b[13].setText("");
            }
        }
        if (e.getSource() == b[14]) {
            String s = b[14].getText();
            if (b[13].getText().equals("")) {
                b[13].setText(s);
                b[14].setText("");
            } else if (b[15].getText().equals("")) {
                b[15].setText(s);
                b[14].setText("");
            } else if (b[10].getText().equals("")) {
                b[10].setText(s);
                b[14].setText("");
            }
        }
        if (e.getSource() == b[6]) {
            String s = b[6].getText();
            if (b[5].getText().equals("")) {
                b[5].setText(s);
                b[6].setText("");
            } else if (b[7].getText().equals("")) {
                b[7].setText(s);
                b[6].setText("");
            } else if (b[2].getText().equals("")) {
                b[2].setText(s);
                b[6].setText("");
            } else if (b[10].getText().equals("")) {
                b[10].setText(s);
                b[6].setText("");
            }
        }
        if (e.getSource() == b[9]) {
            String s = b[9].getText();
            if (b[5].getText().equals("")) {
                b[5].setText(s);
                b[9].setText("");
            } else if (b[8].getText().equals("")) {
                b[8].setText(s);
                b[9].setText("");
            } else if (b[10].getText().equals("")) {
                b[10].setText(s);
                b[9].setText("");
            } else if (b[13].getText().equals("")) {
                b[13].setText(s);
                b[9].setText("");
            }
        }
        if (e.getSource() == b[10]) {
            String s = b[10].getText();
            if (b[6].getText().equals("")) {
                b[6].setText(s);
                b[10].setText("");
            } else if (b[11].getText().equals("")) {
                b[11].setText(s);
                b[10].setText("");
            } else if (b[14].getText().equals("")) {
                b[14].setText(s);
                b[10].setText("");
            } else if (b[9].getText().equals("")) {
                b[9].setText(s);
                b[10].setText("");
            }
        }
        if (e.getSource() == b[5]) {
            String s = b[5].getText();
            if (b[4].getText().equals("")) {
                b[4].setText(s);
                b[5].setText("");
            } else if (b[6].getText().equals("")) {
                b[6].setText(s);
                b[5].setText("");
            } else if (b[1].getText().equals("")) {
                b[1].setText(s);
                b[5].setText("");
            } else if (b[9].getText().equals("")) {
                b[9].setText(s);
                b[5].setText("");
            }
        }
        if (b[0].getText().equals("1") && b[1].getText().equals("2") && b[2].getText().equals("3")
                && b[3].getText().equals("4") && b[4].getText().equals("5") && b[5].getText().equals("6")
                && b[6].getText().equals("7") && b[7].getText().equals("8") && b[8].getText().equals("9")
                && b[9].getText().equals("10") && b[10].getText().equals("11") && b[11].getText().equals("12")
                && b[12].getText().equals("13") && b[13].getText().equals("14") && b[14].getText().equals("15")) {
            JOptionPane.showMessageDialog(this, "You Won!");
        }
        if (e.getSource() == next) {
            restart();
            b[15].setText("");
        }
    }
}
