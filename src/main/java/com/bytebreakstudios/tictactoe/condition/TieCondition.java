package com.bytebreakstudios.tictactoe.condition;

import com.bytebreakstudios.tictactoe.State;
import com.bytebreakstudios.tictactoe.action.TieAction;
import com.bytebreakstudios.board.Condition;

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
