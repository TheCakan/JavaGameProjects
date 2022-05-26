package com.company;

import java.util.Scanner;

import static com.company.Map.playerLocation;

public class Main {
    static Player player = new Player();

    public static void main(String[] args) {
        Map map = new Map();
        char[][] chars = Map.setMap(40, 5, 8, 1); //Set mine and coin amount *, $, #, &
        System.out.println("'*' is mine it will decrease you hp -1 , '#' will decrease your hp -5 \n" +
                "'$' will increase your coin +1 and '&' will increase your coin +3. You need to collect 5 coin");
        System.out.print("Enter your name: ");
        Scanner src = new Scanner(System.in); //Scanner
        String name = src.nextLine(); //Player name variable

        do {
            System.out.println("Player name: " + name);
            System.out.println("HP: " + player.hp);
            System.out.println("Coin: " + player.coin);
            map.printMap();
            System.out.print("'+' is you, you can move to NORTH(N), SOUTH(S), WEST(W) AND EAST(E) \n");
            System.out.println("Where do you want to go ?");
            String where = src.nextLine();
            Map.move(where, chars, playerLocation);
        } while (player.hp != 0);
        if (player.hp == 0 ) {
            lose();
        }

    }

    public static void won() {
        System.out.println("You beat the game");
    }

    public static void lose() {
        System.out.println("You died! Try Again!");
    }
}
