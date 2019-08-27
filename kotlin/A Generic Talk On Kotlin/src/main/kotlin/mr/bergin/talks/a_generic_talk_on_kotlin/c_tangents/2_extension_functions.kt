package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

import java.util.Collections.addAll

//talk about namespace pollution - this is another part of making code readable, since if the compiler
//can tell us what functions are available more easily, we have to read less code!

//good use case - parsing main argument!

fun main(args: Array<String>) {

    val any = Any()
    val string = ""
    val number = 5
    val numberList = arrayOf<Number>()

    //any isIn numberList
}

infix fun <K> K.isIn(iterable: Array<K>) = iterable.contains(this)

fun <K> Array<out K?>.applyDefault((K?) -> K)
    indexOf()
}