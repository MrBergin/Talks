package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

import java.lang.RuntimeException

//Talk about how nothing allows us to use one type to represent all empty lists in a typesafe way.
//You could just cast, and it would all work fine, or you could communicate with the compiler that you
//have a list of Nothing, and it is then happy to use covariance to assign anything to an empty list.

/**
 * Nothing is peculiar feature, it allows us to communicate with the compiler an absence of something, e.g.
 * a function that will never finish (because it always throws an exception).
 */

fun returnsNothing(): Nothing {
    throw RuntimeException("Nothing to see here!")
}

/**
 * It may seem odd, but nothing can be assigned to any type. This is because any type is capable of not existing!
 */
fun nothingIsEverything() {
    val x: String = returnsNothing()
    val y: Int = returnsNothing()
}

/**
 * Now, combine this with "out" variance, let's use a List for example, and you get something quite interesting...
 */
fun nothingIsInteresting() {
    val listOfNothing = listOf<Nothing>()
    val listOfInts: List<Int> = listOfNothing
    val listOfStrings: List<String> = listOfNothing
    val listOfNullableAnything: List<Any?> = listOfNothing

    //all of the above are fine, because list has "out" variance and Nothing is a subtype of any type!
    //this means we have a type-safe way of producing a single instance of something, that works for any type!
    //in fact, this is *almost* what kotlin does!
    val listOfNumbers: List<Number> = emptyList()
}
