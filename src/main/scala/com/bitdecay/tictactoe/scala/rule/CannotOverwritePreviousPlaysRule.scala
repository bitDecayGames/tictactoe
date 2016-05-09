package com.bitdecay.tictactoe.scala.rule

import com.bitdecay.board.{Action, GameBoardState, Rule}
import com.bitdecay.tictactoe.scala.State


object CannotOverwritePreviousPlaysRule extends Rule[State] {
  override def apply(cur: State, next: State, action: Action[_ <: GameBoardState]): Boolean = notOverWritten(cur.q, next.q) && notOverWritten(cur.w, next.w) && notOverWritten(cur.e, next.e) && notOverWritten(cur.a, next.a) && notOverWritten(cur.s, next.s) && notOverWritten(cur.d, next.d) && notOverWritten(cur.z, next.z) && notOverWritten(cur.x, next.x) && notOverWritten(cur.c, next.c)

  private def notOverWritten(a:Int, b:Int) = !(a != 0 && a != b)

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String): Rule[_ <: GameBoardState] = ???
}
