package com.rea.application;

import com.rea.domain.Board;
import com.rea.domain.Game;

import java.util.Scanner;


public class Application {

    public static void main( String[] args ) {


        Game game = new Game(new Board(5,5));

        Scanner scanner = new Scanner(System.in);
        while(true){

            String line = scanner.nextLine();

            Command.parse(line).apply(game);

        }


    }

}
