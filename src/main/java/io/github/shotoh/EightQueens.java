package io.github.shotoh;

import javax.swing.*;

public class EightQueens {
    public static void main(String[] args) {
        int[][] board = new int[8][8];
        if (solve(board, 0)) {
            System.out.println("Solution found");
            printBoard(board);
        } else {
            System.out.println("Solution not found");
        }
    }

    private static boolean solve(int[][] board, int row) {
        if (row == board.length) return true;
        for (int j = 0; j < board[row].length; j++) {
            if (safe(board, row, j)) {
                board[row][j] = 1;
                if (solve(board, row + 1)) return true;
                board[row][j] = 0;
            }
        }
        return false;
    }

    private static boolean safe(int[][] board, int row, int col) {
        int i, j;
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        i = row;
        j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) return false;
            i--;
            j--;
        }
        i = row;
        j = col;
        while (i >= 0 && j < board[0].length) {
            if (board[i][j] == 1) return false;
            i--;
            j++;
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        SwingUtilities.invokeLater(() -> {
            ChessBoard chessBoard = new ChessBoard(board);
            chessBoard.setVisible(true);
        });
    }
}