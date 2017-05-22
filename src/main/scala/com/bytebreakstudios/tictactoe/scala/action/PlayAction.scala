package com.bytebreakstudios.tictactoe.scala.action

import com.bytebreakstudios.board.Action
import com.bytebreakstudios.board.utils.GameBoardException
import com.bytebreakstudios.tictactoe.scala.State

class PlayAction(val key:String, val player:Int) extends Action[State] {
  if (key == null) throw new GameBoardException("Key cannot be null")
  if (player == 0) throw new GameBoardException("Player must either be < 0 or > 0 but not == 0")
  if (!PlayAction.validKeys.contains(key.toLowerCase)) throw new GameBoardException(s"Invalid key: $key")


  override def innerApply(t: State): State = doIt(key.toLowerCase, Math.min(1, Math.max(-1, player)), t)

  override def innerUnapply(t: State): State = doIt(key.toLowerCase, 0, t)

  private def doIt(key:String, player:Int, state:State): State = {
    val tmp:State = key match {
      case "q" => state.copy(q = player)
      case "w" => state.copy(w = player)
      case "e" => state.copy(e = player)
      case "a" => state.copy(a = player)
      case "s" => state.copy(s = player)
      case "d" => state.copy(d = player)
      case "z" => state.copy(z = player)
      case "x" => state.copy(x = player)
      case "c" => state.copy(c = player)
      case _ => throw new GameBoardException(s"Invalid key: $key")
    }
    tmp.copy(lastPlayer = player match {
      case 0 => -1 * this.player
      case _ => player
    })
  }

  override def description(): String = ???

  override def serialize(): String = ???

  override def deserialize(s: String) = ???
}

object PlayAction{
  val validKeys = Seq("q", "w", "e", "a", "s", "d", "z", "x", "c")
}
