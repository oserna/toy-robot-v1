package com.rea.application;

import com.rea.domain.Board;
import com.rea.domain.Direction;
import com.rea.domain.Game;
import com.rea.domain.Position;
import org.junit.Assert;
import org.junit.Test;


public class InitializationTests {

    @Test
    public void givenPlaceInputProperlyFormedResultsInPlaceCommandExecution() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(1,2), Direction.NORTH);

        game.move();

        Assert.assertTrue(TestSuite.check(new Position(1, 3), Direction.NORTH, game.getRobot()));

    }

    @Test
    public void givenAnotherPlaceResultsInNoPlaceCommandExecution() {

        Game game = new Game(new Board(5,5));

        game.place(new Position(1,2), Direction.NORTH);

        Assert.assertTrue(TestSuite.check(new Position(1, 2), Direction.NORTH, game.getRobot()));

        game.place(new Position(0,0), Direction.NORTH);

        Assert.assertTrue(TestSuite.check(new Position(1, 2), Direction.NORTH, game.getRobot()));

    }


}
