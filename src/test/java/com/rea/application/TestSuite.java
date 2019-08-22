package com.rea.application;

import com.rea.domain.Direction;
import com.rea.domain.Position;
import com.rea.domain.Robot;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        InitializationTests.class,
        RotationTests.class,
        MovementTests.class,
})
public class TestSuite {

    public static boolean check(Position expectedPos, Direction expectedDir, Robot robot){
        Position position = robot.getPosition();
        Direction direction = robot.getDirection();

        if (position.getX() != expectedPos.getX()) {
            return false;
        }
        if (position.getY() != expectedPos.getY()) {
            return false;
        }
        if(expectedDir != direction){
            return false;
        }
        return true;
    }


}
