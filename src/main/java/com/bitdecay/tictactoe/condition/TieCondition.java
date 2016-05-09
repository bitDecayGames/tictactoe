package com.bitdecay.tictactoe.condition;

import com.bitdecay.board.Condition;
import com.bitdecay.tictactoe.State;
import com.bitdecay.tictactoe.action.TieAction;

public class TieCondition extends Condition<State, TieAction> {
    public TieCondition() {
        super(new TieAction());
    }

    @Override
    public boolean check(State previous, State current) {
        return !previous.finished && !current.finished &&
                current.q != 0 &&
                current.w != 0 &&
                current.e != 0 &&
                current.a != 0 &&
                current.s != 0 &&
                current.d != 0 &&
                current.z != 0 &&
                current.x != 0 &&
                current.c != 0;
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
    public Condition deserialize(String s) {
        return null;
    }
}
