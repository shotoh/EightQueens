package io.github.shotoh;

import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame {
    public ChessBoard(int[][] queens) {
        setTitle("Eight Queens");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(8, 8));
        boolean isWhite = true;

        for (int i = 0; i < 8; i++) {
            isWhite = !isWhite;
            for (int j = 0; j < 8; j++) {
                JPanel square = new JPanel();
                square.setBackground(isWhite ? Color.WHITE : Color.DARK_GRAY);
                if (queens[i][j] == 1) createQueen(square);
                isWhite = !isWhite;
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