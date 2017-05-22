package com.bytebreakstudios.tictactoe.scala.action

import com.bytebreakstudios.board.Action
import com.bytebreakstudios.tictactoe.scala.State

class TieAction extends Action[State] {
  override def innerApply(t: State): State = t.copy(winner = 0, finished = true)

  override def innerUnapply(t: State): State = t.copy(winner = 0, finished = false)

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String) = ???
}
