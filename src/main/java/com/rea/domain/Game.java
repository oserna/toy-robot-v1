package com.rea.domain;

public class Game {

    private Robot robot;

    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void place(Position position, Direction direction){
        if(robot == null) {

            boolean b = board.checkBoundaries(position);

            robot = new Robot(direction, position);

        }

    }

    public void move() {

        if(robot == null) {
            return;
        }

        Position current = this.robot.getPosition();

        Position newPosition = null;

        switch (this.robot.getDirection()) {
            case NORTH:
                newPosition = new Position(current.getX() , current.getY() + 1);
                if (!this.board.checkBoundaries(newPosition)){
                    return;
                }
                break;
            case EAST:
                newPosition = new Position(current.getX() + 1, current.getY() );
                if (!this.board.checkBoundaries(newPosition)){
                    return;
                }
                break;
            case SOUTH:
                newPosition = new Position(current.getX() , current.getY() - 1);
                if (!this.board.checkBoundaries(newPosition)){
                    return;
                }
                break;
            case WEST:
                newPosition = new Position(current.getX() - 1, current.getY() );
                if (!this.board.checkBoundaries(newPosition)){
                    return;
                }
        }

        this.robot.setPosition(newPosition);
    }

    public void right() {

        if(robot == null) {
            return;
        }

        Direction current = this.robot.getDirection();

        Direction newDirection = Direction.rigth(current);

        this.robot.setDirection(newDirection);
    }

    public void left() {

        if(robot == null) {
            return;
        }

        Direction current = this.robot.getDirection();

        Direction newDirection = Direction.left(current);

        this.robot.setDirection(newDirection);
    }

    public void report() {
        if(robot == null) {
            return;
        }

        System.out.println(this.robot.getPosition() + "," + this.robot.getDirection());
    }

    public Robot getRobot() {
        return robot;
    }

    public Board getBoard() {
        return board;
    }
}
