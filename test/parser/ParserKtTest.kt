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
}
