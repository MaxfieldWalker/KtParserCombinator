package parser

import org.junit.Test

import org.junit.Assert.*

/**
 * Created by n-isida on 2017/04/20.
 */
class ParserKtTest {
    @Test
    fun aParser() {
        val result = aParser("ABC")
        assertEquals(result, Result(true, "BC"))
    }
}
