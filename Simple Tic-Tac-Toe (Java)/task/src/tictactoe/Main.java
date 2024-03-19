package tictactoe;

import java.util.*;

public class Main {
    private static void printField(char[][] ch) {
        System.out.printf("""
                        ---------
                        | %s %s %s |
                        | %s %s %s |
                        | %s %s %s |
                        ---------
                        """,
                ch[0][0], ch[0][1], ch[0][2],
                ch[1][0], ch[1][1], ch[1][2],
                ch[2][0], ch[2][1], ch[2][2]);
    }

    private static void readMove(char[][] inputArr, Scanner sc) {
        int x;
        int y;

        do {

            try {
                x = sc.nextInt();
                y = sc.nextInt();

                if (x > 3 || x < 1 || y > 3 || y < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (inputArr[x - 1][y - 1] != ' ' &&
                        inputArr[x - 1][y - 1] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
            }

        } while (true);

        inputArr[x - 1][y - 1] = 'X';
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            char[] input = sc.next().toCharArray();
            char[][] arr = new char[3][3];
            int count = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = input[count++];
                }
            }

            printField(arr);
            readMove(arr, sc);
            printField(arr);
        }
    }
}
