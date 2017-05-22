package com.bytebreakstudios.tictactoe.action;

import com.bytebreakstudios.tictactoe.State;
import com.bytebreakstudios.board.Action;
import com.bytebreakstudios.board.utils.GameBoardException;

public class PlayAction extends Action<State> {
    private static final String[] validKeys = new String[]{"q", "w", "e", "a", "s", "d", "z", "x", "c"};
    private String key;
    private int player;
    public PlayAction(String key, int player){
        if (key == null) throw new GameBoardException("Key cannot be null");
        if (player == 0) throw new GameBoardException("Player must either be < 0 or > 0 but not == 0");
        this.key = key.toLowerCase();
        this.player = Math.min(1, Math.max(-1, player));

        boolean found = false;
        for (String validKey : validKeys) if(validKey.equals(this.key)) found = true;
        if (!found) throw new GameBoardException("Invalid key: " + key);
    }

    private State doIt(String key, int player, State state){
        switch(key){
            case "q":
                state.q = player;
                break;
            case "w":
                state.w = player;
                break;
            case "e":
                state.e = player;
                break;
            case "a":
                state.a = player;
                break;
            case "s":
                state.s = player;
                break;
            case "d":
                state.d = player;
                break;
            case "z":
                state.z = player;
                break;
            case "x":
                state.x = player;
                break;
            case "c":
                state.c = player;
                break;
            default: throw new GameBoardException("Invalid key: " + key);
        }
        if (player == 0) state.lastPlayer = -1 * this.player;
        else state.lastPlayer = player;
        return state;
    }

    @Override
    protected State innerApply(State state) {
        return doIt(key, player, (State) state.clone());
    }

    @Override
    protected State innerUnapply(State state) {
        return doIt(key, 0, (State) state.clone());
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
