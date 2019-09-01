package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

/**
 * Now, Kotlin's type inference can only take us so far. There are, of course, places where you have to define your
 * verbose generics such as function parameters. So you may end up with something that looks like this:
 */

fun verbosey(wordSoup: Pair<String, List<String>>) {

}

/**
 * Now this isn't the end of the world, but it's still a lot of information for one parameter, you may end up with...
 */
fun whyOhWhyDidIWriteThis(groupedWordSoup: Map<String, Pair<String,List<String>>>, wordSoup: Pair<String, List<String>>) {

}

/**
 * Getting a little harder to read, right? One approach would be to create a data class called WordSoup, and this
 * indeed is a good solution. On the other hand if you're already passing wordSoup around everywhere in your code
 * as a pair and it meets your needs this way, an readability win with no effort would be to use:
 */
typealias WordSoup = Pair<String, List<String>>



/**
 * We can then do the same with groupedWordSoup
 */
typealias GroupedWordSoup = Map<String, WordSoup>

/**
 * With the above we can use generics with less of a wordy appearance!
 */

/**
 * NB for anyone interested: delegating an interface is also a fantastic approach to solving GroupedWordSoup too
 * But I'm assuming we'll have to skip this approach due to time constraints!
 */
//class GroupedWordSoup(init: Map<String, WordSoup>): Map<String, WordSoup> by init


/**
 * Now we are ready for readable code!!!
 */
fun myEyesAreGrateful(groupedWordSoup: GroupedWordSoup, wordSoup: WordSoup) {

}

/**
 * Another redundancy saver: Any patterns you see creeping up in your code base involving generics can also
 * be solved with type aliases.
 */
typealias PairOf<T> = Pair<T, T>
typealias TripleOf<T> = Triple<T, T, T>

/**
 * But wait, there's more! Remember declaration-site variance? Well there's quite a few types in Java which only
 * produce or only consume, wouldn't it be nice if they could benefit from this lovely kotlin feature?
 *
 * With typealiases they can!
 */
typealias Callable<K> = java.util.concurrent.Callable<out K> //Callable only ever produces K, so this is fine!
var callableNumber = Callable<Number> { 5 }
var callableAny: Callable<Any> = callableNumber //If we used java.util.concurrent.Callable, this wouldn't work!

/**
 * typealiases give us a lot with generics:
 *
 * Flexibility: we can apply kotlin features like declaration site variance to java types.
 * Readability: we can condense verbose generic type definitions for easier to read apis.
 */