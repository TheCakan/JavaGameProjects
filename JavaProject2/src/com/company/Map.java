package com.company;

import java.util.Random;

public class Map {
    static char[][] chars = new char[9][9];
    static char[][] playerLocation = new char[9][9];

    public static void move(String loc, char[][] map, char[][] playerLoc) {

        //Variables for movement i use it for player current location
        int ploc_x = 0, ploc_y = 0;

        for (int i = 0; 9 > i; i++) { //Find player position
            for (int k = 0; 9 > k; k++) {
                if (playerLoc[i][k] == '+') {
                    ploc_x = i; //Get positions
                    ploc_y = k;
                }
            }
        }

        //Movement
        switch (loc) {
            case "E":
                if (map[ploc_x][ploc_y + 1] == '-' || map[ploc_x][ploc_y + 1] == '#' ||
                        map[ploc_x][ploc_y + 1] == '*' || map[ploc_x][ploc_y + 1] == '$' ||
                        map[ploc_x][ploc_y + 1] == '&') {
                    //Decreasing hp when hitting mine
                    if (map[ploc_x][ploc_y + 1] == '*')
                        Main.player.hp--; //Decrease hp
                    else if (map[ploc_x][ploc_y + 1] == '$')
                        Main.player.coin++; //Increase coin
                    else if (map[ploc_x][ploc_y + 1] == '&')
                        Main.player.coin = Main.player.coin + 3; //Increase coin +3
                    else if (map[ploc_x][ploc_y + 1] == '#') {
                        Main.player.hp = Main.player.hp - 5; //Decrease hp -5
                    }
                    playerLoc[ploc_x][ploc_y] = '-'; //Printing - to the last location in player map
                    map[ploc_x][ploc_y] = '-';              //Printing - to the last location in map
                    playerLoc[ploc_x][ploc_y + 1] = '+';  //Printing + to new location in player map
                    map[ploc_x][ploc_y + 1] = '+';        //Printing + to new location in map
                    break;
                }
            case "W":
                if (map[ploc_x][ploc_y - 1] == '-' || map[ploc_x][ploc_y - 1] == '#' ||
                        map[ploc_x][ploc_y - 1] == '*' || map[ploc_x][ploc_y - 1] == '$' ||
                        map[ploc_x][ploc_y - 1] == '&') {
                    if (map[ploc_x][ploc_y - 1] == '*')
                        Main.player.hp--;
                    else if (map[ploc_x][ploc_y - 1] == '$')
                        Main.player.coin++;
                    else if (map[ploc_x][ploc_y - 1] == '&')
                        Main.player.coin = Main.player.coin + 3;
                    else if (map[ploc_x][ploc_y - 1] == '#') {
                        Main.player.hp = Main.player.hp - 5;
                    }
                    playerLoc[ploc_x][ploc_y] = '-';
                    map[ploc_x][ploc_y] = '-';
                    playerLoc[ploc_x][ploc_y - 1] = '+';
                    map[ploc_x][ploc_y - 1] = '+';
                    break;
                }
            case "N":
                if (map[ploc_x - 1][ploc_y] == '-' || map[ploc_x - 1][ploc_y] == '#' ||
                        map[ploc_x - 1][ploc_y] == '*' || map[ploc_x - 1][ploc_y] == '$' ||
                        map[ploc_x - 1][ploc_y] == '&') {
                    if (map[ploc_x - 1][ploc_y] == '*')
                        Main.player.hp--;
                    else if (map[ploc_x - 1][ploc_y] == '$')
                        Main.player.coin++;
                    else if (map[ploc_x - 1][ploc_y] == '&')
                        Main.player.coin = Main.player.coin + 3;
                    else if (map[ploc_x - 1][ploc_y] == '#') {
                        Main.player.hp = Main.player.hp - 5;
                    }
                    playerLoc[ploc_x][ploc_y] = '-';
                    map[ploc_x][ploc_y] = '-';
                    playerLoc[ploc_x - 1][ploc_y] = '+';
                    map[ploc_x - 1][ploc_y] = '+';
                    break;
                }
            case "S":
                if (map[ploc_x + 1][ploc_y] == '-' || map[ploc_x + 1][ploc_y] == '#' ||
                        map[ploc_x + 1][ploc_y] == '*' || map[ploc_x + 1][ploc_y] == '$' ||
                        map[ploc_x + 1][ploc_y] == '&') {
                    if (map[ploc_x + 1][ploc_y] == '*')
                        Main.player.hp--;
                    else if (map[ploc_x + 1][ploc_y] == '$')
                        Main.player.coin++;
                    else if (map[ploc_x + 1][ploc_y] == '&')
                        Main.player.coin = Main.player.coin + 3;
                    else if (map[ploc_x + 1][ploc_y] == '#') {
                        Main.player.hp = Main.player.hp - 5;
                    }
                    playerLoc[ploc_x][ploc_y] = '-';
                    map[ploc_x][ploc_y] = '-';
                    playerLoc[ploc_x + 1][ploc_y] = '+';
                    map[ploc_x + 1][ploc_y] = '+';
                    break;
                }
            default:
                System.out.println("Wrong vay.");
                break;
        }
        printMap();
    }

    public static char[][] setMap(int x, int y, int e, int z) {

        //ran = random, rem = remaining, div = divide
        int i, j, zcal, ecal, xcal, ycal, ran, rem, div;
        Random r = new Random();

        //Filling the map with '-'
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                chars[i][j] = '-';
            }
        }

        playerLocation[4][4] = '+'; //Player spawn locatin in playermap
        chars[4][4] = '+'; //Point player spawn location

        //Calculating and generating mine location
        xcal = 0;
        do {
            ran = r.nextInt(81); //If we get 56 from here
            rem = ran % 9; // rem = 2 column position
            ran = ran - rem; //ran = 54
            div = ran / 9; //div = 6 line position

            //Replacing '-' with '*'
            if (chars[div][rem] == '-') {
                chars[div][rem] = '*';
                xcal++;
            }
        } while (xcal < x);

        //Calculating and generating coin location
        ycal = 0;
        do {
            ran = r.nextInt(81);
            rem = ran % 9;
            ran = ran - rem;
            div = ran / 9;

            //Replacing '-' with '$'
            if (chars[div][rem] == '-') {
                chars[div][rem] = '$';
                ycal++;
            }
        } while (ycal < y);
        ecal = 0;
        do {
            ran = r.nextInt(81);
            rem = ran % 9;
            ran = ran - rem;
            div = ran / 9;

            //Replacing '-' with '$'
            if (chars[div][rem] == '-') {
                chars[div][rem] = '#';
                ecal++;
            }
        } while (ecal < e);
        zcal = 0;
        do {
            ran = r.nextInt(81);
            rem = ran % 9;
            ran = ran - rem;
            div = ran / 9;

            //Replacing '-' with '&'
            if (chars[div][rem] == '-') {
                chars[div][rem] = '&';
                zcal++;
            }
        } while (zcal < z);
        return chars;
    }

    //Printing map
    public static void printMap() {

        for (int k = 0; k < 9; k++) {
            for (int e = 0; e < 9; e++) {
                if (chars[k][e] == '-')
                    System.out.print("- ");
                else if (chars[k][e] == '*')
                    System.out.print("* ");
                else if (chars[k][e] == '$')
                    System.out.print("$ ");
                else if (chars[k][e] == '+')
                    System.out.print("+ ");
                else if (chars[k][e] == '#')
                    System.out.print("# ");
                else if (chars[k][e] == '&')
                    System.out.print("& ");
            }
            System.out.print("\n");
        }
    }

}