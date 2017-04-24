package parser

/**
 * Created by n-isida on 2017/04/20.
 */

data class Result<T>(val value: T, val remaining: String)
typealias  Parser<T> = (String) -> Result<T>

fun pchar(charToMatch: Char): (String) -> Result<Char> {
    val innerFn = { str: String ->
        if (str.isNullOrEmpty()) {
            val message = "No more input"
            throw Exception(message)
        } else {
            val first = str[0]
            if (first == charToMatch) {
                val remaining = str.substring(1)
                Result(charToMatch, remaining)
            } else {
                val message = String.format("Expecting '%c'. Got '%c'", charToMatch, first)
                throw  Exception(message)
            }
        }
    }

    return innerFn
}

fun <T> run(parser: Parser<T>, str: String): Result<T> {
    return parser(str)
}
