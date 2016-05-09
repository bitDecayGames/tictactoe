package com.bitdecay.tictactoe.scala.action

import com.bitdecay.board.Action
import com.bitdecay.tictactoe.scala.State

class ChangeTurnAction extends Action[State] {
  override def innerApply(t: State): State = t.copy(xTurn = !t.xTurn)

  override def innerUnapply(t: State): State = innerApply(t)

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String) = ???
}
