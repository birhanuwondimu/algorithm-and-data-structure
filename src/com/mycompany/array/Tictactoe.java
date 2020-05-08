package com.mycompany.array;

public class Tictactoe {

    int[][]board;
    int n ;
    public Tictactoe(int n) {
        board = new int[n][n];
        for(int i =0;i<n;i++)
            for(int j =0;j<n;j++)
                board[i][j] =-1;
        this.n = n;
    }
    public String tictactoe(int[][] moves) {
        int n = moves.length;
        if (n < 5) {
            return "Pending";
        } else if (n < 9) {
            if (wonByLastMove(moves)) {
                return n % 2 == 1 ? "A" : "B";
            } else {
                return "Pending";
            }
        }
        return wonByLastMove(moves) ? "A" : "Draw";
    }

    public int move(int row, int col, int player) {
        board[row][col] =player;
        if(rowWinner(row,col,player)
                ||colWinner(row,col,player)
                ||(row==col &&diaWinner(player))
                ||(row==n-1-col &&RevdiaWinner(player)))
            return player;
        return 0;



    }

    private boolean rowWinner(int row, int col, int player){
        for(int i =0;i<n;i++){
            if(board[row][i] !=player)
                return false;
        }
        return true;
    }

    private boolean colWinner(int row, int col, int player){
        for(int i =0;i<n;i++){
            if(board[i][col] !=player)
                return false;
        }
        return true;
    }

    private boolean diaWinner(int player){
        for(int i =0;i<n;i++){
            if(board[i][i] !=player)
                return false;
        }
        return true;
    }

    private boolean RevdiaWinner( int player){
        for(int i =0;i<n;i++){
            if(board[i][n-1-i] !=player)
                return false;
        }
        return true;
    }

    private boolean wonByLastMove(int[][] moves) {
        int[] lastMove = moves[moves.length-1];
        int row = 1, col = 1, diag = 1, revDiag = 1;

        for (int i = moves.length-3; i >= 0; i -= 2) {
            int[] curr = moves[i];
            if (curr[0] == lastMove[0]) row++;
            if (curr[1] == lastMove[1]) col++;
            if (curr[0] == curr[1] && lastMove[0] == lastMove[1]) diag++;
            if (curr[0] + curr[1] == 2 && lastMove[0] + lastMove[1] == 2) revDiag++;
        }
        return row == 3 || col == 3 || diag == 3 || revDiag == 3;
    }

    public  static  void  main(String[]args){
       int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};
        Tictactoe obj = new Tictactoe(2);
     int param_1 = obj.move(0,1,2);
        int param_2 = obj.move(1,0,1);
        int param_3 = obj.move(1,1,2);
     //[[2],[0,1,2],[1,0,1],[1,1,2]]
    }
}
