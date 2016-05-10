package com.bitdecay.tictactoe.scala

import com.bitdecay.board.GameBoardState

case class State(q:Int=0,
                 w:Int=0,
                 e:Int=0,
                 a:Int=0,
                 s:Int=0,
                 d:Int=0,
                 z:Int=0,
                 x:Int=0,
                 c:Int=0,
                 winner:Int=0,
                 xTurn:Boolean=false,
                 lastPlayer:Int= -1,
                 finished:Boolean=false) extends GameBoardState {
  override lazy val serialize: String = s"$boardToString\n\n${State.print(winner)}, $xTurn, $finished, ${State.print(lastPlayer)}"
  private lazy val boardToString:String =
    s"""${State.print(q)}|${State.print(w)}|${State.print(e)}
       /-----
       /${State.print(a)}|${State.print(s)}|${State.print(d)}
       /-----
       /${State.print(z)}|${State.print(x)}|${State.print(c)}
     """.stripMargin('/')

  override def deserialize(str: String): GameBoardState = {
    val rows = str.split("\n")
    val values = rows.filter(_.contains("|")).flatMap(_.split("\\|"))
    val results = rows.last.split(", ")
    State(
      q=State.read(values(0)),
      w=State.read(values(0)),
      e=State.read(values(0)),
      a=State.read(values(0)),
      s=State.read(values(0)),
      d=State.read(values(0)),
      z=State.read(values(0)),
      x=State.read(values(0)),
      c=State.read(values(0)),
      winner=State.read(results(0)),
      xTurn=State.readBoolean(results(1)),
      finished=State.readBoolean(results(2)),
      lastPlayer=State.read(results(3))
    )
  }

  lazy val topRow = q + w + e
  lazy val midRow = a + s + d
  lazy val botRow = z + x + c
  lazy val leftCol = q + a + z
  lazy val midCol = w + s + x
  lazy val rightCol = e + d + c
  lazy val leftDiag = q + s + c
  lazy val rightDiag = e + s + z

  override lazy val toString = boardToString

  override lazy val clone:Object = copy()
}

object State {
  private def print(i:Int):String = i match {
    case -1 => "X"
    case 1 => "O"
    case _ => " "
  }

  private def read(s:String):Int = s.toLowerCase match {
    case "x" => -1
    case "o" => 1
    case _ => 0
  }

  private def readBoolean(s:String):Boolean = s.toLowerCase.equalsIgnoreCase("true")
}
