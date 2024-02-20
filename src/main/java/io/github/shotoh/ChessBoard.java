package io.github.shotoh;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {
    public ChessBoard(int[][] queens) {
        // set standard options
        setTitle("Eight Queens");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 8 by 8 grid layout
        JPanel panel = new JPanel(new GridLayout(8, 8));
        boolean white = true;

        for (int i = 0; i < 8; i++) {
            white = !white; // alternates between white and black
            for (int j = 0; j < 8; j++) {
                JPanel square = new JPanel();
                square.setBackground(white ? Color.WHITE : Color.DARK_GRAY);
                if (queens[i][j] == 1) createQueen(square); // adds an icon to the square
                white = !white; // alternates between white and black
                panel.add(square);
            }
        }
        add(panel);
    }

    private void createQueen(JPanel square) {
        square.setLayout(new BorderLayout());
        JLabel label = new JLabel(new ImageIcon("src/main/resources/queen.png"));
        square.add(label, BorderLayout.CENTER);
    }
}