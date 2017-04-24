import parser.andThen
import parser.pchar
import parser.run

/**
 * Created by n-isida on 2017/04/20.
 */


fun main(args: Array<String>) {
    val parseA = pchar('A')
    val parseB = pchar('B')
    val parseAThenB = andThen(parseA, parseB)
    val result = run(parseAThenB, "ACD")
    println(result)
}
