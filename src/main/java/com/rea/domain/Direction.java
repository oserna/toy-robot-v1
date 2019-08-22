package com.rea.domain;

public enum Direction {

    NORTH, EAST, SOUTH, WEST, VOID;

    public static Direction rigth(Direction direction) {
        switch (direction) {
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return VOID;
        }
    }

    public static  Direction left(Direction direction) {
        switch (direction) {
            case NORTH: return WEST;
            case WEST:  return SOUTH;
            case SOUTH: return EAST;
            case EAST:  return NORTH;
            default: return VOID;
        }
    }

    public static Direction getType(String direction) {

        for (Direction d : Direction.values()) {
            if(d.name().equals(direction)){
                return d;
            }
        };

        return VOID;
    }
}
