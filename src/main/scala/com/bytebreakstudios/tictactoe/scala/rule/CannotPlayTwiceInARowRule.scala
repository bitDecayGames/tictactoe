package com.bytebreakstudios.tictactoe.scala.rule

import com.bytebreakstudios.board._
import com.bytebreakstudios.tictactoe.scala.State
import com.bytebreakstudios.tictactoe.scala.action.PlayAction

object CannotPlayTwiceInARowRule extends Rule[State] {
  override def apply(cur: State, next: State, action: Action[_ <: GameBoardState]): Boolean = action match {
    case _:PlayAction => cur.lastPlayer != next.lastPlayer
    case _ => true
  }

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String): Rule[_ <: GameBoardState] = ???
}
