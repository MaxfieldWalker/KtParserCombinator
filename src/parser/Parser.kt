package parser

/**
 * Created by n-isida on 2017/04/20.
 */

data class Result (val success: Boolean, val remaining: String)

fun aParser(str: String):Result {
    if(str.isNullOrEmpty()){
        return Result(false, "")
    }else if(str[0].equals('A')) {
        val remaining = str.substring(1)
        return Result(true, remaining)
    }else{
        return  Result(false, str)
    }
}
