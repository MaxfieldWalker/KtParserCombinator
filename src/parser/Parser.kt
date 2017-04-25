package parser

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

fun <T> andThen(parser1: Parser<T>, parser2: Parser<T>): Parser<Pair<T, T>> {
    val innerFn = { str: String ->
        // 1つ目のパーサーを適用
        val result1 = run(parser1, str)
        // 2つ目のパーサーを適用
        val result2 = run(parser2, result1.remaining)

        // パース結果を結合
        val newValue = Pair(result1.value, result2.value)
        Result(newValue, result2.remaining)
    }

    return innerFn
}

fun <T> orElse(parser1: Parser<T>, parser2: Parser<T>): Parser<T> {
    val innerFn = { str: String ->
        try {
            val result1 = run(parser1, str)
            result1
        } catch (ex1: Exception) {
            val result2 = run(parser2, str)
            result2
        }
    }

    return innerFn
}

fun <T> choice(listOfParsers: List<Parser<T>>): Parser<T> {
    return listOfParsers.reduce { p1, p2 -> orElse(p1, p2) }
}

fun anyOf(listOfChars: List<Char>): Parser<Char> {
    val parsers = listOfChars.map(::pchar)
    return choice(parsers)
}
