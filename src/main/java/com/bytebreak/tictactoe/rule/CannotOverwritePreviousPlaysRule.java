package com.bytebreak.tictactoe.rule;

import com.bitdecay.board.Action;
import com.bitdecay.board.Rule;
import com.bytebreak.tictactoe.State;

public class CannotOverwritePreviousPlaysRule implements Rule<State> {
    @Override
    public boolean apply(State current, State next, Action action) {
        return notOverWritten(current.q, next.q) &&
                notOverWritten(current.w, next.w) &&
                notOverWritten(current.e, next.e) &&
                notOverWritten(current.a, next.a) &&
                notOverWritten(current.s, next.s) &&
                notOverWritten(current.d, next.d) &&
                notOverWritten(current.z, next.z) &&
                notOverWritten(current.x, next.x) &&
                notOverWritten(current.c, next.c);
    }

    private boolean notOverWritten(int a, int b){
        return !(a != 0 && a != b);
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
