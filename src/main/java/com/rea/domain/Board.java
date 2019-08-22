package com.rea.domain;

public class Board {

    private  int x;
    private  int y;

    public Board(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public boolean checkBoundaries(Position position){

        if (isValidDimension(position.getX(), x ) && isValidDimension(position.getY(), y )){
            return true;
        }

        return false;
    }

    private boolean isValidDimension(int dimension, int limit){
        if (dimension < 0 || dimension > limit -1 ) {
            return false;
        }

        return true;
    }
}
