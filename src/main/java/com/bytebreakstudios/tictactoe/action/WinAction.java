package com.bytebreakstudios.tictactoe.action;

import com.bytebreakstudios.tictactoe.State;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.utils.GameBoardException;

public class WinAction extends Action<State> {
    private int side = 0;

    public void setSide(int side){
        if (side == 0) throw new GameBoardException("Side cannot be 0");
        this.side = side;
    }

    @Override
    protected State innerApply(State state) {
        State next = (State) state.clone();
        next.winner = side;
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
