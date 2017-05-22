package com.bytebreakstudios.tictactoe.scala.condition

import com.bytebreakstudios.board.Condition
import com.bytebreakstudios.tictactoe.scala.State
import com.bytebreakstudios.tictactoe.scala.action.WinAction

object WinCondition extends Condition[State, WinAction](new WinAction) {

  override def check(prev: State, cur: State): Boolean = {
    if (!prev.finished && !cur.finished) {
      val winner = testForWinner(cur)
      if (winner != 0){
        action.setSide(winner)
        return true
      }
    }
    false
  }

  private def testForWinner(s:State):Int = Seq(s.topRow, s.midRow, s.botRow, s.leftCol, s.midCol, s.rightCol, s.leftDiag, s.rightDiag).find(i => i == -3 || i == 3).getOrElse(0)

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String) = ???
}