package games;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class maze extends JFrame implements KeyListener {
    JLabel title = new JLabel("MAZE");
    Font titleFont = new Font("arial", Font.BOLD, 32);

    Image icon = Toolkit.getDefaultToolkit().getImage("games/maze_icon.png");
    int puzzle[][] = {
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, -1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1 },
            { 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1 },
            { 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }
    };
    JLabel l[][] = new JLabel[10][13];
    int pi = 1, pj = 1;

    Container c = new Container();
    GridLayout grid = new GridLayout(10, 13);

    private void reset() {
        pi = 1;
        pj = 1;
        l[pi][pj].setBackground(Color.YELLOW);
        l[8][11].setBackground(Color.GREEN);
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            if (puzzle[pi - 1][pj] != 1) {
                l[pi][pj].setBackground(Color.WHITE);
                pi--;
                l[pi][pj].setBackground(Color.YELLOW);
            }
        } else if (e.getKeyChar() == 's') {
            if (puzzle[pi + 1][pj] != 1) {
                l[pi][pj].setBackground(Color.WHITE);
                pi++;
                l[pi][pj].setBackground(Color.YELLOW);
            }
        } else if (e.getKeyChar() == 'a') {
            if (puzzle[pi][pj - 1] != 1) {
                l[pi][pj].setBackground(Color.WHITE);
                pj--;
                l[pi][pj].setBackground(Color.YELLOW);
            }
        } else if (e.getKeyChar() == 'd') {
            if (puzzle[pi][pj + 1] != 1) {
                l[pi][pj].setBackground(Color.WHITE);
                pj++;
                l[pi][pj].setBackground(Color.YELLOW);
            }
        }
        if (pi == 8 && pj == 11) {
            JDialog over = new JDialog();
            JLabel l = new JLabel("You found the way HOME!!!");
            l.setBounds(10, 10, 180, 40);
            over.add(l);
            over.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent w) {
                    over.setVisible(false);
                    reset();
                }
            });
            over.setSize(300, 100);
            over.setLayout(null);
            over.setLocationRelativeTo(null);
            over.setVisible(true);
        }
    }

    public maze() {
        super("Maze Game");
        this.getContentPane().setBackground(new Color(90, 90, 90));

        title.setBounds(150, 30, 130, 30);
        title.setFont(titleFont);
        title.setForeground(new Color(255, 255, 240));
        title.setHorizontalAlignment(JLabel.CENTER);

        c.setBounds(10, 100, 400, 340);
        c.setLayout(grid);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 13; j++) {
                l[i][j] = new JLabel();
                l[i][j].setOpaque(true);
                if (puzzle[i][j] == 1) {
                    l[i][j].setBackground(Color.BLUE);
                } else if (puzzle[i][j] == -1) {
                    l[i][j].setBackground(Color.YELLOW);
                } else if (puzzle[i][j] == 2) {
                    l[i][j].setBackground(Color.GREEN);
                } else {
                    l[i][j].setBackground(Color.WHITE);
                }
                c.add(l[i][j]);
            }
        }

        add(title);
        add(c);

        addKeyListener(this);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent w) {
                setVisible(false);
            }
        });
        setIconImage(icon);
        setSize(433, 550);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
    }
}
