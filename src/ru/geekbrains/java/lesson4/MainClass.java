package ru.geekbrains.java.lesson4;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by admin on 23.03.2017.
 */
public class MainClass {

    public static Scanner sc = new Scanner(System.in);
    public static final int SIZE = 5;
    public static final int DOT_TO_WIN = 5;

    public static final char DOTX = 'X';
    public static final char DOTO = 'O';
    public static final char EMPTY_DOT = '.';
    public static Random rand = new Random();
    public static char[][] map;

    public static void main(String[] args) {

        initMap();
        while (fullMap()) {
            aiTurn();
            printMap();
            winCheck(DOTO);
        }


    }

    public static boolean winCheck(char player_dot) {
        int x=0;
        int y=0;
        for (int i = 0; i < SIZE; i++,x=0,y=0) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j]==player_dot) x++;
                if (map[j][i]==player_dot) y++;
            }
            if (x==SIZE){
                System.out.println("ПОБЕДА");
                return true;
            }
            if (y==SIZE){
                System.out.println("ПОБЕДА");
                return true;
            }
        }
        return false;
    }

    public static boolean fullMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == EMPTY_DOT) return true;
            }
        }
        return false;
    }

    public static void humanTurn() {
        while (true) {
            System.out.println("Ваш ход, введите X Y");
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            if (map[y][x] == EMPTY_DOT) {
                map[y][x] = DOTX;
                break;
            }
        }
    }

    public static void aiTurn() {
        while (true) {
            int x = rand.nextInt(SIZE);
            int y = rand.nextInt(SIZE);
            if (map[y][x] == EMPTY_DOT) {
                map[y][x] = DOTO;
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = EMPTY_DOT;
            }
        }
    }

    public static void printMap() {
        System.out.println();
        for (int i = 0; i <= SIZE; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%3d", i + 1);
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%3c", map[i][j]);
            }
            System.out.println();
        }
    }


}
