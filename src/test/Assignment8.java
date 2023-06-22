package test;
// Elena Savkina
// 79790747
// COSC 111 L02 Assignment 8
// single player battleship game 
import java.util.Scanner;
/**
 * A little (6x6?) Battleship game
 *
 * @author Jim Nastos
 */
public class Assignment8 {

    public static void main(String[] args) {
    
        final int SIZE = 6;
        int[][] board = {   {2,0,0,0,0,0},
                            {2,0,0,0,3,0},
                            {0,0,0,0,3,0},
                            {0,0,0,0,3,0},
                            {0,0,0,0,0,0},
                            {0,0,4,4,4,4} };
                            
        char[][] guesses = new char[SIZE][SIZE];

        boolean thereAreShips = true;

        // counters to track attacks and number of hits
        int count = 0;
        int patrol = 0;
        int destr = 0;
        int battle = 0;
        
        while(thereAreShips) {
            // display the board
            displayGuesses(guesses);

            // ask user for their guess (e.g. "B5")
            Scanner in = new Scanner(System.in);
            System.out.print("Please enter a guess in the form 'B5': ");
            String guess = in.next();

            // turn their guess string into a row index and column index
            guess = guess.toLowerCase();

            // convert chars to indices correctly
            int row = guess.charAt(0) - 97;
            int col = guess.charAt(1) - 49;

            // check the game board if it is a hit or a miss
            boolean hit = false;
            if(board[row][col] != 0)
                hit = true;

            // update the guesses board accordingly

            // check if it's repeating attack
            if(guesses[row][col] != 0) {
                System.out.println("The place was already attacked! Try again.");
                continue;
            }

            // increment attack number
            count++;
            if(hit) {
                guesses[row][col] = 'X';
            } else {
                guesses[row][col] = 'O';
            }

            // decide if the ship is sunk

            // temporary scores
            int t_patrol = 0;
            int t_destr = 0;
            int t_battle = 0;

            if(hit) {
                for(int i = 0; i < board.length; i++) {
                    for(int j = 0; j < board[i].length; j++) {
                        // if matches on both board and guesses, increment temporary score
                        if(board[i][j] != 0 && guesses[i][j] == 'X') {
                            if(board[i][j] == 2) {
                                t_patrol++;
                            } else if(board[i][j] == 3) {
                                t_destr++;
                            } else if(board[i][j] == 4) {
                                t_battle++;
                            }
                        }
                    }
                }
            }

            // if temporary score is bigger than the actual (thus, updated), update actual score
            if(t_patrol > patrol)
                patrol = t_patrol;
            if(t_destr > destr)
                destr = t_destr;
            if(t_battle > battle)
                battle = t_battle;

            // output message to user
            // if the ship is sunk, increment above its value to prevent repeating messages
            if(patrol == 2) {
                System.out.println("You sunk the Patrol Boat!");
                patrol++;
            }
            if(destr == 3) {
                System.out.println("You sunk the Destroyer!");
                destr++;
            }
            if(battle == 4) {
                System.out.println("You sunk the Battleship!");
                battle++;
            }

            // if all actual scores are above their counters, end the game
            if(patrol == 3 && destr == 4 && battle == 5) {
                System.out.println("Game over, you win! You used " + count + " attacks.");
                thereAreShips = false;
            }
        }

    }
    
    public static void displayGuesses(char[][] g) {
        System.out.println();
        System.out.print(" ");
        for (int c=1; c<=g[0].length; c++ ) System.out.print(c);
        System.out.println();
        for (int row=0; row<g.length; row++) {
            System.out.print(""+(char)('A'+row));
            for (int col=0; col<g[row].length; col++) {
                if (g[row][col]=='O') System.out.print("O");
                else if (g[row][col]=='X') System.out.print("X");
                else System.out.print(".");
            }
            System.out.println(); 
        }               
    }
}
