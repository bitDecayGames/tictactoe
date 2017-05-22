package com.bytebreakstudios.tictactoe.scala.action

import com.bytebreakstudios.board.Action
import com.bytebreakstudios.board.utils.GameBoardException
import com.bytebreakstudios.tictactoe.scala.State

class WinAction extends Action[State] {
  private var side:Int = 0
  def setSide(side:Int) = if (side == 0) throw new GameBoardException("Side cannot be 0") else this.side = side

  override def innerApply(t: State): State = t.copy(winner=side, finished=true)

  override def innerUnapply(t: State): State = t.copy(winner=0, finished=false)

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String) = ???
}
