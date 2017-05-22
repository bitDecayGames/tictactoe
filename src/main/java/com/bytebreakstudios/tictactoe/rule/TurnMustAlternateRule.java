package com.bytebreakstudios.tictactoe.rule;

import com.bytebreakstudios.tictactoe.State;
import com.bytebreakstudios.tictactoe.action.ChangeTurnAction;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.Rule;

public class TurnMustAlternateRule implements Rule<State> {
    @Override
    public boolean apply(State current, State next, Action action) {
        if (action instanceof ChangeTurnAction) return current.xTurn != next.xTurn;
        return true;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public String serialize() {
        return null;
    }

    @Override
    public Rule deserialize(String s) {
        return null;
    }
}
