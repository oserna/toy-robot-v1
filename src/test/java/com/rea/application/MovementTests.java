package com.rea.application;

import com.rea.domain.Board;
import com.rea.domain.Direction;
import com.rea.domain.Game;
import com.rea.domain.Position;
import org.junit.Assert;
import org.junit.Test;


public class MovementTests {


    @Test
    public void givenNorthMoveResultsInExpectedPosition() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.NORTH);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(0, 1), Direction.NORTH, game.getRobot()));

    }

    @Test
    public void givenEastMoveResultsInExpectedPosition() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.EAST);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(1, 0), Direction.EAST, game.getRobot()));

    }

    @Test
    public void givenSouthtMoveResultsInExpectedPosition() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(4,4), Direction.SOUTH);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(4, 3), Direction.SOUTH, game.getRobot()));
    }

    @Test
    public void givenWestMoveResultsInExpectedPosition() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(4,0), Direction.WEST);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(3, 0), Direction.WEST, game.getRobot()));

    }

    @Test
    public void givenMoveInputResultsInMoveCommandExecution() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.EAST);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(1, 0), Direction.EAST, game.getRobot()));

    }

    @Test
    public void givenMoveCommandsResultIsWithinHeightBoundaries() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.SOUTH);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.SOUTH, game.getRobot()));

        game.right();

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.WEST, game.getRobot()));

        game.right();

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(0, 1), Direction.NORTH, game.getRobot()));
    }

    @Test
    public void givenMoveCommandsResultIsWithinWidthBoundaries() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(4,4), Direction.NORTH);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(4, 4), Direction.NORTH, game.getRobot()));

        game.right();

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(4, 4), Direction.EAST, game.getRobot()));

        game.right();

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(4, 3), Direction.SOUTH, game.getRobot()));


    }

}
