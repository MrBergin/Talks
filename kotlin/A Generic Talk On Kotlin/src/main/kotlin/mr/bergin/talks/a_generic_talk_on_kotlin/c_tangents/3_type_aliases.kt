package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

//Now, Kotlin's type inference can only take us so far. There are, of course, places where you have to define your
//verbose generics such as function parameters. So you may end up with something that looks like this:

fun verbosey(wordSoup: Pair<String, List<String>>) {

}

/**
 * Now this isn't the end of the world, but it's still a lot of information for one parameter, you may end up with...
 */

fun whyOhWhyDidIWriteThis(groupedWordSoup: Map<String, Pair<String,List<String>>>, wordSoup: Pair<String, List<String>>) {

}

/**
 * Getting a little harder to read, right? Now of course a good approach would be to look into introducing new types
 * to represent this groupedWordSoup and wordSoup, in fact with groupedWordSoup you're in luck since it's an interface
 * and kotlin can use delegation for that, the type is still exactly the same
 */
class GroupedWordSoupUgly(groupedWordSoup: Map<String, Pair<String, List<String>>>): Map<String, Pair<String,List<String>>> by groupedWordSoup

/**
 * But there's two problems, one is the above is still making our eyes bleed, and we can't apply the same logic to
 * our wordSoup parameter because it's not an interface. You could introduce an entirely new type for it, but then
 * you would not be able to use it as a pair elsewhere (which may already be doing) without converting it back and forth.
 */

typealias WordSoup = Pair<String, List<String>>

/**
 * Now we are ready for readable code!!!
 */

class GroupedWordSoup(init: Map<String, WordSoup>): Map<String, WordSoup> by init

/**
 * Now it's easy to read and both parameters are the same type as they were before.
 */
fun myEyesAreGrateful(groupedWordSoup: GroupedWordSoup, wordSoup: WordSoup) {

}

/**
 * Another redundancy saver: Any patterns you see creeping up in your code base involving generics can also
 * be solved with type aliases.
 */
typealias PairOf<T> = Pair<T, T>
typealias TripleOf<T> = Triple<T, T, T>