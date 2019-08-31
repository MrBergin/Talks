package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

import java.lang.RuntimeException

/**
 * Nothing is peculiar feature, it allows us to communicate with the compiler an absence of something, e.g.
 * a function that will never finish (because it always throws an exception).
 */
fun returnsNothing(): Nothing {
    throw RuntimeException("Nothing to see here!")
}

/**
 * It may seem odd, but nothing can be assigned to any type. This is because any type is capable of not existing!
 *
 * Think of Nothing as the opposite of Any? - everything is a child of Any? and a parent of Nothing.
 */
fun nothingIsEverything() {
    val x: String = returnsNothing()
    val y: Int = returnsNothing()
}

/**
 * Let's see how this behaves with "out" variance, for example a List (which has declaration-site variance out).
 */
fun nothingIsInteresting() {

    //all of these work because Nothing is a subtype of everything.
    val listOfNothing = listOf<Nothing>()
    val listOfInts: List<Int> = listOfNothing
    val listOfStrings: List<String> = listOfNothing
    val listOfNullableAnything: List<Any?> = listOfNothing

    //since that one list of nothing can be assigned to any type of list, this means we have a way
    //of representing all types of lists with only one instance, in fact this is exactly how the
    //kotlin standard library achieves a single type safe empty list that can be used for any type of empty list!

    val listOfNumbers: List<Number> = emptyList()
    val listOfAny: List<Any> = emptyList()
}
