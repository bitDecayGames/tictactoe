package com.bytebreakstudios.tictactoe;

import com.bytebreakstudios.tictactoe.action.TieAction;
import com.bytebreakstudios.tictactoe.action.WinAction;
import com.bytebreakstudios.tictactoe.condition.TieCondition;
import com.bytebreakstudios.tictactoe.condition.WinCondition;
import org.junit.Assert;
import org.junit.Test;

public class ConditionsTest {

    @Test
    public void testTieCondition() {
        TieCondition condition = new TieCondition();
        State a = new State();
        State b = new State();
        Assert.assertFalse("There is no tie", condition.check(a, b));

        b.q = -1;
        b.w = -1;
        b.e = -1;
        b.a = -1;
        b.s = -1;
        b.d = -1;
        b.z = -1;
        b.x = -1;
        b.c = -1;
        Assert.assertTrue("There should be a tie", condition.check(a, b));

        TieAction action = new TieAction();
        State c = action.apply(b);
        Assert.assertFalse("There should not be a tie anymore because the game is already finished", condition.check(b, c));
    }

    @Test
    public void testWinCondition() {
        WinCondition condition = new WinCondition();
        State a = new State();
        State b = new State();
        Assert.assertFalse("There is no winner", condition.check(a, b));

        b.e = -1;
        b.s = -1;
        b.z = -1;
        Assert.assertTrue("There should be a winner", condition.check(a, b));

        WinAction action = new WinAction();
        action.setSide(-1);
        State c = action.apply(b);
        Assert.assertFalse("There should not be a winner anymore because the game is already finished", condition.check(b, c));
    }
}
