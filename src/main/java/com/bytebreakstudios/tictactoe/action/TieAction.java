package com.bytebreakstudios.tictactoe.action;

import com.bytebreakstudios.tictactoe.State;
import com.bytebreakstudios.board.Action;

public class TieAction extends Action<State> {

    @Override
    protected State innerApply(State state) {
        State next = (State) state.clone();
        next.winner = 0;
        next.finished = true;
        return next;
    }

    @Override
    protected State innerUnapply(State state) {
        State next = (State) state.clone();
        next.winner = 0;
        next.finished = false;
        return next;
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
