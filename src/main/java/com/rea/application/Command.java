package com.rea.application;


import com.rea.domain.Direction;
import com.rea.domain.Game;
import com.rea.domain.Position;

public interface Command {

    Command VOID_COMMAND = i -> {};

    void apply(Game game);

    static Command parse(String input) {
        if(input == null || input.trim().equals("")) {
            return VOID_COMMAND;
        }

        String[] parts = input.split(" ");

        switch(parts[0].trim()) {
            case "PLACE":

                if(parts.length != 2){
                    return VOID_COMMAND;
                }

                String[] placeParams = parts[1].split(",");

                if (placeParams.length != 3) {
                    return VOID_COMMAND;
                }

                if (!isValidInteger(placeParams[0].trim()) || !isValidInteger(placeParams[1].trim())) {
                    return VOID_COMMAND;
                }

                Position position = new Position(Integer.parseInt(placeParams[0].trim()), Integer.parseInt(placeParams[1].trim()));

                Direction direction = Direction.getType(placeParams[2].trim());

                if (direction == Direction.VOID){
                    return VOID_COMMAND;
                }

                return game -> game.place(position, direction);

            case "MOVE":
                return Game::move;

            case "RIGHT":
                return Game::right;

            case "LEFT":
                return Game::left;

            case "REPORT":
                return Game::report;

            default:
                return VOID_COMMAND;
        }
    }

    public static boolean isValidInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex){
            return false;
        }
    }
}