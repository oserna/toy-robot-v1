package com.rea.application;

import com.rea.domain.Board;
import com.rea.domain.Direction;
import com.rea.domain.Game;
import com.rea.domain.Position;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;



public class RotationTests {

    @Test
    public void givenRightResultsInRightCommandExecution() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.NORTH);

        game.right();

        Position position = game.getRobot().getPosition();
        Direction direction = game.getRobot().getDirection();

        Assert.assertEquals(0, position.getX());
        Assert.assertEquals(0, position.getY());
        Assert.assertEquals("EAST", direction.name());
    }


    @Test
    public void givenLeftResultsInLeftCommandExecution() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.NORTH);

        game.left();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.WEST, game.getRobot()));

    }

    @Test
    public void givenSubsequentLeftCommandsResultInProperLeftRotation() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.NORTH);

        game.left();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.WEST, game.getRobot()));

        game.left();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.SOUTH, game.getRobot()));

        game.left();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.EAST, game.getRobot()));

        game.left();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.NORTH, game.getRobot()));

    }

    @Test
    public void givenSubsequentRightCommandsResultInProperRightRotation() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(0,0), Direction.NORTH);

        game.right();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.EAST, game.getRobot()));

        game.right();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.SOUTH, game.getRobot()));

        game.right();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.WEST, game.getRobot()));

        game.right();

        Assert.assertTrue(TestSuite.check(new Position(0, 0), Direction.NORTH, game.getRobot()));
    }



}
