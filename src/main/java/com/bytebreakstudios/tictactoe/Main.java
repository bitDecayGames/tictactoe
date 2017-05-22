package com.bytebreakstudios.tictactoe;

import com.bytebreakstudios.tictactoe.action.ChangeTurnAction;
import com.bytebreakstudios.tictactoe.action.PlayAction;
import com.bytebreakstudios.tictactoe.condition.TieCondition;
import com.bytebreakstudios.tictactoe.condition.WinCondition;
import com.bytebreakstudios.tictactoe.rule.CannotOverwritePreviousPlaysRule;
import com.bytebreakstudios.tictactoe.rule.CannotPlayTwiceInARowRule;
import com.bytebreakstudios.tictactoe.rule.TurnMustAlternateRule;
import com.bytebreakstudios.board.Conditions;
import com.bytebreakstudios.board.GameBoard;
import com.bytebreakstudios.board.Rules;
import com.bytebreakstudios.board.utils.GameBoardException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        GameBoard<State> gameBoard = new GameBoard<>(new State(), new Rules<>(new CannotOverwritePreviousPlaysRule(), new CannotPlayTwiceInARowRule(), new TurnMustAlternateRule()), new Conditions<>(new TieCondition(), new WinCondition()));

        int turns = 0;
        State currentState = gameBoard.currentState();
        System.out.println(currentState);
        System.out.println("\n");
        while(!currentState.finished && turns <= 9){
            gameBoard.submitAction(new PlayAction(pickRandomKey(currentState), currentState.lastPlayer * -1));
            gameBoard.submitAction(new ChangeTurnAction());
            gameBoard.step();
            currentState = gameBoard.currentState();
            System.out.println(currentState);
            System.out.println("\n");
            turns++;
        }
        if (turns > 9) throw new GameBoardException("There shouldn't have been more than 9 turns");
        if (currentState.winner != 0) System.out.println("Winner!!!! Player: " + (currentState.winner < 0 ? "X" : "O"));
        else System.out.println("Cats game!");
    }

    static String pickRandomKey(State currentState){
        List<String> validKeys = new ArrayList<>();
        if (currentState.q == 0) validKeys.add("q");
        if (currentState.w == 0) validKeys.add("w");
        if (currentState.e == 0) validKeys.add("e");
        if (currentState.a == 0) validKeys.add("a");
        if (currentState.s == 0) validKeys.add("s");
        if (currentState.d == 0) validKeys.add("d");
        if (currentState.z == 0) validKeys.add("z");
        if (currentState.x == 0) validKeys.add("x");
        if (currentState.c == 0) validKeys.add("c");
        if (validKeys.size() == 0) throw new GameBoardException("There were no more valid moves");
        int index = (int)Math.round(Math.random() * (double)(validKeys.size() - 1));
        return validKeys.get(index);
    }
}
