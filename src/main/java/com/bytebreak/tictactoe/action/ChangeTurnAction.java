package com.bytebreak.tictactoe.action;


import com.bitdecay.board.Action;
import com.bytebreak.tictactoe.State;

public class ChangeTurnAction extends Action<State> {

    @Override
    protected State innerApply(State state) {
        State next = (State) state.clone();
        next.xTurn = !next.xTurn;
        return next;
    }

    @Override
    protected State innerUnapply(State state) {
        return innerApply(state);
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
    public Object deserialize(String s) {
        return null;
    }
}
