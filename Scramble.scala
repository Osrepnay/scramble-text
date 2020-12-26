import scala.io.StdIn

object Scramble {

	def main(args: Array[String]) = {
		print("Text to scramble: ")
		val text = StdIn.readLine()
		println(scrambleText(text).mkString("\n"))
	}
	
	def scrambleText(text: String): List[String] = {
		if(text.length == 1) {
			text :: Nil
		} else {
			text.indices.flatMap(idx => scrambleText(text.patch(idx, Nil, 1)).map(tail => s"${text(idx)}$tail")).toList
		}
	}

}
