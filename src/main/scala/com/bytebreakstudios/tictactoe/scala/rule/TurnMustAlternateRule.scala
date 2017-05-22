package com.bytebreakstudios.tictactoe.scala.rule

import com.bytebreakstudios.board._
import com.bytebreakstudios.tictactoe.scala.State
import com.bytebreakstudios.tictactoe.scala.action.ChangeTurnAction

object TurnMustAlternateRule extends Rule[State] {
  override def apply(cur: State, next: State, action: Action[_ <: GameBoardState]): Boolean = action match {
    case _:ChangeTurnAction => cur.xTurn != next.xTurn
    case _ => true
  }

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String): Rule[_ <: GameBoardState] = ???
}
