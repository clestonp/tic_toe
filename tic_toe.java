package tictactoe;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String inp = scanner.next();
        int dim = inp.length();
        int cont = 0;


        char[][] matrix = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = inp.charAt(cont);
                cont++;
            }
        }
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        // Ask input for next move
        int next_move1 = 0;
        int next_move2 = 0;

        boolean ask = true;
        boolean ask1 = true;

        while (ask) {

            System.out.println("Enter the coordinates: ");

            try {
                next_move1 = scanner.nextInt();
                next_move2 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
                next_move2 = 0;
                continue;
            }

            // Check valid range
            if (next_move1 > 3 || next_move2 > 3) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }


            int r1= 0; int r2= 0;
            if (next_move2 == 1 || next_move2 == 3) {
                if (next_move2 == 1)
                    r1 = 3;
                else
                    r1 = 1;
                r2 = next_move1;
                System.out.println(r1 + " " + r2);
                char pos = matrix[r1 - 1][r2 - 1];
                if (pos == 'X' || pos == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                matrix[r1 - 1][r2 - 1] = 'X';
                ask = false;
            }
            int tmp = next_move2;
            if (next_move2 == 2) {
                r1 = tmp ;
                r2 = next_move1;
                char pos = matrix[r1 - 1][r2 - 1];
                if (pos == 'X' || pos == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                matrix[r1 - 1][r2 - 1] = 'X';
                ask = false;
            }

        }
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");




/*
        int countX = 0;
        int countO = 0;
        int count_ = 0;
        int index = 0;
        // COUNT Xs and Os
        for (int i = 0; i < dim; i++) {
            if (inp.charAt(i) == 'X') {
                countX++;
            }else if (inp.charAt(i) == 'O') {
                countO++;
            }
        }

        // Game checking

        int win = 0;
        char winChar = '0';
        char winCharX = '0';
        char winCharO = '0';

        // CHECK PER RIGHE
        for (int p = 0; p < inp.length(); ) {
            boolean com_primo = inp.charAt(p) == inp.charAt(p+1) ;
            boolean com_secondo = inp.charAt(p) == inp.charAt(p+2);
            boolean com_terzo = (inp.charAt(p+2) == inp.charAt(p+1));
            if ( com_primo && com_secondo  && com_terzo ) {
                win++;
                winChar = inp.charAt(p);
                if (winChar == 'X') {
                    winCharX = 'X';
                }else if (winChar == 'O') {
                    winCharO = 'O';
                }
            }
            p = p+3;
        }
        // CHECK PER COLONNE
        for (int p = 3; p <= 5; ) {
            boolean com_primo = inp.charAt(p) == inp.charAt(p-3) ;
            boolean com_secondo = inp.charAt(p) == inp.charAt(p+3);
            boolean com_terzo = (inp.charAt(p+3) == inp.charAt(p-3));
            if ( com_primo && com_secondo  && com_terzo ) {
                win++;
                winChar = inp.charAt(p);
                if (winChar == 'X') {
                    winCharX = 'X';
                }else if (winChar == 'O') {
                    winCharO = 'O';
                }
            }
            p = p+1;
        }

        // CHECK PER DIagonale PRINCIPALE
        for (int i = 0; i < 8; ) {
            boolean com_primo = inp.charAt(i) == inp.charAt(i+4) ;
            boolean com_secondo = inp.charAt(i) == inp.charAt(i+8);
            boolean com_terzo = (inp.charAt(i+4) == inp.charAt(i+8));
            if ( com_primo && com_secondo  && com_terzo ) {
                win++;
                winChar = inp.charAt(i);
                if (winChar == 'X') {
                    winCharX = 'X';
                }else if (winChar == 'O') {
                    winCharO = 'O';
                }
            }
            i = i + 8;
        }
        // CHECK PER DIagonale SECONDARIA
        for (int i = 2; i < 6; ) {
            boolean com_primo = inp.charAt(i) == inp.charAt(i+2) ;
            boolean com_secondo = inp.charAt(i) == inp.charAt(i+4);
            boolean com_terzo = (inp.charAt(i+2) == inp.charAt(i+4));
            if ( com_primo && com_secondo  && com_terzo ) {
                win++;
                winChar = inp.charAt(i);
                if (winChar == 'X') {
                    winCharX = 'X';
                }else if (winChar == 'O') {
                    winCharO = 'O';
                }
            }
            i = i + 9;
        }

        // GAME NOT FINISHED
        for (int i = 0; i < dim; i++){
            if (inp.charAt(i) == '_') {
                count_++;
            }
        }


       // IMPOSSIBLE AND OTHER POSSIBLE OUTCOMES
        if ( (winChar == '0') && count_ == 0 ) {
            System.out.println("Draw");
        }else if ( (winCharO == 'O') && (winCharX == 'X')) {
            System.out.println("Impossible");
        }else if ( (countX - countO) > 1 || (countO - countX) > 1) {
            System.out.println("Impossible");
        }else  if ( (count_ > 0) && winChar == '0') {
            System.out.println("Game not finished");
        }else if (winChar != '0') {
            System.out.println(winChar + " wins");
        }
       */
    }
}
