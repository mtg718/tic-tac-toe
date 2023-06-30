import java.util.Scanner;

public class tictactoe {

    public static void main(String[] args) {
        char board[][] = new char[3][3];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                board[row][col] = ' ';
            }
        }

        char player = 'X';
        boolean gameOver = false;// let game is not over
        Scanner sc = new Scanner(System.in);

        while (!gameOver) {
            printBoard(board);
            System.out.print("Player " + player + " Enter: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            if (board[row][col] == ' ') {// board not filled
                // place the player
                board[row][col] = player;

                gameOver = hadWon(board, player);
                if (gameOver) {
                    System.out.println("Player " + player + " has won. ");
                } else {
                    // switch players
                    if (player == 'X') {
                        player = 'O';

                    } else {
                        player = 'X';

                    }
                }

            } else {
                // board already filled at that place
                System.out.println("INVALID ENTRY");
            }

        }
        // print final board
        printBoard(board);

    }

    // hadwon function

    public static boolean hadWon(char board[][], char player) {

        // won across column ,diagonal and rows

        // checking the rows
        for (int row = 0; row < board.length; row++) {

            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }

        // checking for columns

        for (int col = 0; col < board.length; col++) {

            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }

        //checking for diagonal
//left dia
if(board[0][0]==player && board[1][1]==player && board[2][2]==player ){
    return true;
}

//right dia
if(board[0][2]==player && board[1][1]==player && board[2][0]==player ){
    return true;
}

//if nothing above are true
return false;

    }

    // printboard funvtion
    public static void printBoard(char board[][]) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {

                System.out.print(board[row][col] + " | ");

            }
            System.out.println();
        }
    }
}