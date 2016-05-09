package com.bitdecay.tictactoe;

import com.bitdecay.tictactoe.action.ChangeTurnAction;
import com.bitdecay.tictactoe.action.PlayAction;
import com.bitdecay.tictactoe.rule.CannotOverwritePreviousPlaysRule;
import com.bitdecay.tictactoe.rule.CannotPlayTwiceInARowRule;
import com.bitdecay.tictactoe.rule.TurnMustAlternateRule;
import org.junit.Assert;
import org.junit.Test;

public class RulesTest {

    @Test
    public void testCannotOverwritePreviousPlays(){
        CannotOverwritePreviousPlaysRule rule = new CannotOverwritePreviousPlaysRule();
        State a = new State();
        PlayAction firstAction = new PlayAction("q", 1);
        State b = firstAction.apply(a);
        Assert.assertTrue("Rule must return true", rule.apply(a, b, firstAction));
        PlayAction overwritingAction = new PlayAction("q", -1);
        State c = overwritingAction.apply(b);
        Assert.assertFalse("Rule must return false", rule.apply(b, c, overwritingAction));
    }

    @Test
    public void testCannotPlayTwiceInARow(){
        CannotPlayTwiceInARowRule rule = new CannotPlayTwiceInARowRule();
        State a = new State();
        PlayAction firstAction = new PlayAction("q", 1);
        State b = firstAction.apply(a);
        Assert.assertTrue("Rule must return true", rule.apply(a, b, firstAction));
        PlayAction secondAction = new PlayAction("w", 1);
        State c = secondAction.apply(b);
        Assert.assertFalse("Rule must return false", rule.apply(b, c, secondAction));
    }

    @Test
    public void testTurnMustAlternate(){
        TurnMustAlternateRule rule = new TurnMustAlternateRule();
        State a = new State();
        ChangeTurnAction firstAction = new ChangeTurnAction();
        State b = firstAction.apply(a);
        Assert.assertNotEquals("Turn must be different", a.xTurn, b.xTurn);
        ChangeTurnAction secondAction = new ChangeTurnAction();
        State c = secondAction.apply(b);
        Assert.assertNotEquals("Turn must be different", b.xTurn, c.xTurn);
        Assert.assertEquals("Turn must be the same", a.xTurn, c.xTurn);
    }
}
