package tictactoe;

import java.util.Scanner;

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

    public static class State {
        private boolean finished;
        private boolean win;
        private char winChar;
        private boolean impossible;
        private int winId;
        private boolean charX;
        private boolean charO;
    }

    private static State getState(char[][] inputArr) {
        State state = new State();

        if (inputArr[0][0] == inputArr[0][1] && inputArr[0][1] == inputArr[0][2] ||
                inputArr[0][0] == inputArr[1][0] && inputArr[1][0] == inputArr[2][0]) {

            checkState(state, inputArr, 0);
        }

        if (inputArr[0][0] == inputArr[1][1] && inputArr[1][1] == inputArr[2][2] ||
                inputArr[1][0] == inputArr[1][1] && inputArr[1][1] == inputArr[1][2] ||
                inputArr[0][2] == inputArr[1][1] && inputArr[1][1] == inputArr[2][0] ||
                inputArr[0][1] == inputArr[1][1] && inputArr[1][1] == inputArr[2][1]) {

            checkState(state, inputArr, 1);
        }

        if (inputArr[0][2] == inputArr[1][2] && inputArr[1][2] == inputArr[2][2] ||
                inputArr[2][0] == inputArr[2][1] && inputArr[2][1] == inputArr[2][2]) {

            checkState(state, inputArr, 2);
        }

        state.impossible = count_X_O(inputArr) || state.charO && state.charX;
        state.finished = countSpace(inputArr) == 0 || state.win;
        state.winChar = inputArr[state.winId][state.winId];

        return state;
    }

    private static void checkState(State state, char[][] inputArr, int winId) {
        state.winId = winId;

        if (inputArr[state.winId][state.winId] != ' ') {
            state.win = true;

            if (inputArr[state.winId][state.winId] == 'X') {
                state.charX = true;
            } else {
                state.charO = true;
            }
        }
    }

    private static boolean count_X_O(char[][] inputArr) {
        int X = 0;
        int O = 0;

        for (char[] chars : inputArr) {
            for (char ch : chars) {
                if (ch == 'X') {
                    X++;
                } else if (ch == 'O') {
                    O++;
                }
            }
        }

        return Math.abs(X - O) > 1;
    }

    private static int countSpace(char[][] inputArr) {
        int count = 0;

        for (char[] chars : inputArr) {
            for (char ch : chars) {
                if (ch == ' ' || ch == '_') {
                    count++;
                }
            }
        }

        return count;
    }

    private static void printState(State state) {
        if (state.impossible) {
            System.out.println("Impossible");
        } else if (!state.finished) {
            System.out.println("Game not finished");
        } else if (!state.win) {
            System.out.println("Draw");
        } else {
            System.out.println(state.winChar + " wins");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();
        char[][] arr = new char[3][3];
        int count = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = input[count++];
            }
        }

        printField(arr);
        printState(getState(arr));
    }
}
