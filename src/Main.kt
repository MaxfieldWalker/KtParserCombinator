import parser.pchar
import parser.run

/**
 * Created by n-isida on 2017/04/20.
 */


fun main(args: Array<String>) {
    val aParser = pchar('A')
    val result = run(aParser, "ABC")
    println(result)
}
