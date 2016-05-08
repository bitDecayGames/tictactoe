package com.bytebreak.tictactoe.rule;

import com.bitdecay.board.Action;
import com.bitdecay.board.Rule;
import com.bytebreak.tictactoe.State;
import com.bytebreak.tictactoe.action.PlayAction;

public class CannotPlayTwiceInARowRule implements Rule<State> {
    @Override
    public boolean apply(State current, State next, Action action) {
        if (action instanceof PlayAction) return current.lastPlayer != next.lastPlayer;
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
