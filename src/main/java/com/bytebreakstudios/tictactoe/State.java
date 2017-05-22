package com.bytebreakstudios.tictactoe;

import com.bytebreakstudios.board.GameBoardState;
import com.bytebreakstudios.board.utils.GameBoardException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class State implements GameBoardState {
    public int q = 0;
    public int w = 0;
    public int e = 0;
    public int a = 0;
    public int s = 0;
    public int d = 0;
    public int z = 0;
    public int x = 0;
    public int c = 0;
    public int winner = 0;
    public boolean xTurn = false;
    public int lastPlayer = -1;
    public boolean finished = false;

    private String print(int i){
        if (i == -1) return "X";
        else if (i == 1) return "O";
        else return " ";
    }

    private int read(String s){
        if (s.equalsIgnoreCase("X")) return -1;
        else if (s.equalsIgnoreCase("O")) return 1;
        else return 0;
    }

    private boolean readBoolean(String s){
        return s.equalsIgnoreCase("true");
    }

    @Override
    public String serialize() {
        StringBuilder sb = new StringBuilder();
        sb.append(boardToString()).append("\n\n");
        sb.append(print(winner)).append(", ").append(xTurn).append(", ").append(finished).append(", ").append(print(lastPlayer));
        return sb.toString();
    }

    private String boardToString(){
        StringBuilder sb = new StringBuilder();
        sb.append(print(q)).append("|").append(print(w)).append("|").append(print(e)).append("\n");
        sb.append("-----").append("\n");
        sb.append(print(a)).append("|").append(print(s)).append("|").append(print(d)).append("\n");
        sb.append("-----").append("\n");
        sb.append(print(z)).append("|").append(print(x)).append("|").append(print(c));
        return sb.toString();
    }

    @Override
    public GameBoardState deserialize(String str) {
        String[] rows = str.split("\n");
        List<String> vals = new ArrayList<>();
        for (String row : rows) if (row.contains("|")) Collections.addAll(vals, row.split("\\|"));
        q = read(vals.get(0));
        w = read(vals.get(1));
        e = read(vals.get(2));
        a = read(vals.get(3));
        s = read(vals.get(4));
        d = read(vals.get(5));
        z = read(vals.get(6));
        x = read(vals.get(7));
        c = read(vals.get(8));
        String[] results = rows[6].split(", ");
        this.winner = read(results[0]);
        this.xTurn = readBoolean(results[1]);
        this.finished = readBoolean(results[2]);
        this.lastPlayer = read(results[3]);
        return this;
    }

    public int topRow(){
        return q + w + e;
    }
    public int midRow(){
        return a + s + d;
    }
    public int botRow(){
        return z + x + c;
    }
    public int leftCol(){
        return q + a + z;
    }
    public int midCol(){
        return a + s + d;
    }
    public int rightCol(){ return e + d + c; }
    public int leftDiag(){
        return q + s + c;
    }
    public int rightDiag(){
        return e + s + z;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new GameBoardException("This should never happen", e);
        }
    }

    @Override
    public String toString() {
        return boardToString();
    }
}
