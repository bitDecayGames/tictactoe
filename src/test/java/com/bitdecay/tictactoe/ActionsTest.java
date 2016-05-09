package com.bitdecay.tictactoe;

import com.bitdecay.tictactoe.action.ChangeTurnAction;
import com.bitdecay.tictactoe.action.PlayAction;
import com.bitdecay.tictactoe.action.TieAction;
import com.bitdecay.tictactoe.action.WinAction;
import org.junit.Assert;
import org.junit.Test;

public class ActionsTest {

    @Test
    public void testWinAction(){
        WinAction action = new WinAction();
        int side = -1;
        action.setSide(side);
        State a = new State();
        State b = action.apply(a);
        State c = action.unapply(b);
        Assert.assertEquals(a.winner, c.winner);
        Assert.assertEquals(a.finished, c.finished);
        Assert.assertEquals(b.winner, side);
        Assert.assertTrue(b.finished);
    }

    @Test
    public void testTieAction(){
        TieAction action = new TieAction();
        State a = new State();
        State b = action.apply(a);
        State c = action.unapply(b);
        Assert.assertEquals(a.winner, c.winner);
        Assert.assertEquals(a.finished, c.finished);
        Assert.assertEquals(b.winner, a.winner);
        Assert.assertTrue(b.finished);
    }

    @Test
    public void testPlayAction(){
        PlayAction action = new PlayAction("q", -1);
        State a = new State();
        State b = action.apply(a);
        State c = action.unapply(b);
        Assert.assertEquals(a.q, c.q);
        Assert.assertNotEquals(a.q, b.q);
        Assert.assertEquals(b.q, -1);
    }

    @Test
    public void testChangeTurnAction(){
        ChangeTurnAction action = new ChangeTurnAction();
        State a = new State();
        State b = action.apply(a);
        State c = action.unapply(b);
        Assert.assertEquals(a.xTurn, c.xTurn);
        Assert.assertNotEquals(a.xTurn, b.xTurn);
    }
}
