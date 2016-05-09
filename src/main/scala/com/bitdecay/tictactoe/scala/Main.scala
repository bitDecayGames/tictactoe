package com.bitdecay.tictactoe.scala

import com.bitdecay.board.utils.GameBoardException
import com.bitdecay.board.{Conditions, GameBoard, Rules}
import com.bitdecay.tictactoe.scala.action.{ChangeTurnAction, PlayAction}
import com.bitdecay.tictactoe.scala.condition.{TieCondition, WinCondition}
import com.bitdecay.tictactoe.scala.rule.{CannotOverwritePreviousPlaysRule, CannotPlayTwiceInARowRule, TurnMustAlternateRule}

object Main extends App {
  val gameBoard: GameBoard[State] = new GameBoard(State(), new Rules[State](CannotOverwritePreviousPlaysRule, CannotPlayTwiceInARowRule, TurnMustAlternateRule), new Conditions[State](TieCondition, WinCondition))

  var turns:Int = 0
  var curState = gameBoard.currentState
  println(s"$curState\n")
  while(!curState.finished && turns <= 9){
    gameBoard.submitAction(new PlayAction(pickRandomKey(curState), curState.lastPlayer * -1))
    gameBoard.submitAction(new ChangeTurnAction())
    gameBoard.step();
    curState = gameBoard.currentState()
    println(s"$curState\n")
    turns += 1
  }
  if (turns > 9) throw new GameBoardException("There shouldn't have been more than 9 turns")
  if (curState.winner != 0) println(s"Winner!!!! Player: ${if (curState.winner < 0) "X" else "O" }")
  else println("Cats game!")

  def pickRandomKey(curState:State): String = {
    val validKeys = Seq(
      (curState.q, "q"),
      (curState.w, "w"),
      (curState.e, "e"),
      (curState.a, "a"),
      (curState.s, "s"),
      (curState.d, "d"),
      (curState.z, "z"),
      (curState.x, "x"),
      (curState.c, "c")
    ).filter {
      case (v: Int, key: String) => v == 0
    }.map {
      case (_, key:String) => key
    }
    val index:Int = Math.round(Math.random() * (validKeys.size - 1).toDouble).toInt
    validKeys(index)
  }
}
