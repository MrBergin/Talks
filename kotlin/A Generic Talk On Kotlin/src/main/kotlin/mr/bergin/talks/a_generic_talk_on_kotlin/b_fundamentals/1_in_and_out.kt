package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals

import java.util.*

/**
 * Let's get stuck IN! This section is about the keyword: in
 */

/**
 * The keyword in is Kotlin's way of letting you communicate that you're only going to put things "in" to
 * a generic type.
 *
 * e.g. MutableList<in Int> would only allow you to call methods like add, or replace.
*/
fun addAnswers(answers: MutableList<in Int>) {
    answers.add(42)
    //answers.get() //What will happen here?
}

/**
 * You can see here, since we've communicated we'll only put Ints into "answers", the compiler knows it's OK
 * to pass in a list of Numbers, since it's perfectly valid to place an Int in a collection of Numbers
 */
fun mainAddAnswers() {
    val numbers = mutableListOf<Number>()
    addAnswers(numbers)
}


/**
 * Let's check the following section OUT! You guess it, this section covers the keyword: out
 */

/**
 * Like above the keyword in is Kotlin's way of letting you communicate that you only need to take things "out"
 * e.g.
 *
 * e.g. MutableList<out Int> would only allow you to call methods like get, first or last.
 */
fun containsTrueAnswer(answers: MutableList<out Number>): Boolean {
    return answers.any { it == 42 }
}

/**
 * You can see here, since we've communicated we'll only read Numbers out of "answers", the compiler knows it's OK
 * to pass in a list of Int, since Ints are Numbers.
 */
fun mainContainsTrueAnswer() {
    val numbers = mutableListOf<Int>()
    containsTrueAnswer(numbers)
}
