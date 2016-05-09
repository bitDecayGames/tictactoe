package com.bitdecay.tictactoe.scala.condition

import com.bitdecay.board.{Action, Condition, GameBoardState}
import com.bitdecay.tictactoe.scala.State
import com.bitdecay.tictactoe.scala.action.TieAction

object TieCondition extends Condition[State, TieAction](new TieAction) {

  override def check(prev: State, cur: State): Boolean = !prev.finished && !cur.finished && cur.q != 0 && cur.w != 0 && cur.e != 0 && cur.a != 0 && cur.s != 0 && cur.d != 0 && cur.z != 0 && cur.x != 0 && cur.c != 0

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String) = ???
}