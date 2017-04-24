import parser.orElese
import parser.pchar
import parser.run

/**
 * Created by n-isida on 2017/04/20.
 */


fun main(args: Array<String>) {
    val parseA = pchar('A')
    val parseB = pchar('B')
    val parseAOrElseB = orElese(parseA, parseB)
    val result = run(parseAOrElseB, "ABC")
    println(result)
}
