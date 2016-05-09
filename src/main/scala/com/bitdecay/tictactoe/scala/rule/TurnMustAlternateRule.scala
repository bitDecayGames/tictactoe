package com.bitdecay.tictactoe.scala.rule

import com.bitdecay.board.{Action, GameBoardState, Rule}
import com.bitdecay.tictactoe.scala.State
import com.bitdecay.tictactoe.scala.action.ChangeTurnAction

object TurnMustAlternateRule extends Rule[State] {
  override def apply(cur: State, next: State, action: Action[_ <: GameBoardState]): Boolean = action match {
    case _:ChangeTurnAction => cur.xTurn != next.xTurn
    case _ => true
  }

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String): Rule[_ <: GameBoardState] = ???
}
