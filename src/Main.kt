import parser.anyOf
import parser.run

/**
 * Created by n-isida on 2017/04/20.
 */


fun main(args: Array<String>) {
    val lowercase = ('a'..'z').toList()
    val digits = ('0'..'9').toList()
    val parseLowercase = anyOf(lowercase)
    val parseDigit = anyOf(digits)

    val result1 = run(parseLowercase, "abc")
    val result2 = run(parseDigit, "123")
}
