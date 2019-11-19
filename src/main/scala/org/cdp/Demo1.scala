package org.cdp

import org.antlr.v4.runtime.atn.PredictionMode
import org.antlr.v4.runtime.{CharStreams, CommonTokenStream}
import org.cdp.parser.{SqlBaseLexer, SqlBaseParser}

object Demo1 {
  def main(args: Array[String]): Unit = {
    val sql = "CREATE TABLE `abcd`(`name` STRING,`age` INT)"

    val lexer = new SqlBaseLexer(CharStreams.fromString(sql))
    lexer.removeErrorListeners()

    val tokenStream = new CommonTokenStream(lexer)
    val parser = new SqlBaseParser(tokenStream)
    parser.removeErrorListeners()
    parser.getInterpreter.setPredictionMode(PredictionMode.SLL)
  }
}
