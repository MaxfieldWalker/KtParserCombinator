package parser

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by n-isida on 2017/04/20.
 */
class ParserKtTest {
    @Test
    fun pcharTest() {
        val A_Parser = pchar('A')
        val result = parser.run(A_Parser, "ABC")

        assertEquals(Result('A', "BC"), result)
    }

    @Test
    fun andThenTest() {
        val parseA = pchar('A')
        val parseB = pchar('B')

        val parseAAndThenB = andThen(parseA, parseB)

        val result = parser.run(parseAAndThenB, "ABC")

        assertEquals(Result(Pair('A', 'B'), "C"), result)
    }

    @Test
    fun orElseTest() {
        val parseA = pchar('A')
        val parseB = pchar('B')
        val parseAOrElseB = orElse(parseA, parseB)

        val result1 = parser.run(parseAOrElseB, "ABC")
        assertEquals(Result('A', "BC"), result1)

        val result2 = parser.run(parseAOrElseB, "BBC")
        assertEquals(Result('B', "BC"), result2)
    }

    @Test
    fun choiceTest() {
        val parseA = pchar('A')
        val parseB = pchar('B')
        val parseAOrElseB = choice(listOf(parseA, parseB))

        val result1 = parser.run(parseAOrElseB, "ABC")
        assertEquals(Result('A', "BC"), result1)

        val result2 = parser.run(parseAOrElseB, "BBC")
        assertEquals(Result('B', "BC"), result2)
    }
}
