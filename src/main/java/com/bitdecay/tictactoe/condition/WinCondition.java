package com.bitdecay.tictactoe.condition;

import com.bitdecay.board.Condition;
import com.bitdecay.tictactoe.State;
import com.bitdecay.tictactoe.action.WinAction;

public class WinCondition extends Condition<State, WinAction> {
    public WinCondition(){
        super(new WinAction());
    }

    @Override
    public boolean check(State previous, State current) {
        if (!previous.finished && !current.finished){
            int winner = winner(current);
            if (winner != 0){
                action.setSide(winner);
                return true;
            }
        }
        return false;
    }

    private int winner(State s){
        int[] checks = new int[]{
                s.topRow(),
                s.midRow(),
                s.botRow(),
                s.leftCol(),
                s.midCol(),
                s.rightCol(),
                s.leftDiag(),
                s.rightDiag()
        };
        for (int check : checks){
            if (check == -3 || check == 3) return check;
        }
        return 0;
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
