package tictactoe;

import java.util.Scanner;

public class Main {
    private static void printField(char[] ch) {
        System.out.printf("""
                        ---------
                        | %s %s %s |
                        | %s %s %s |
                        | %s %s %s |
                        ---------""",
                ch[0], ch[1], ch[2],
                ch[3], ch[4], ch[5],
                ch[6], ch[7], ch[8]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printField(sc.next().toCharArray());
    }
}