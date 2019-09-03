package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

/**
 * Now let's look at an example that uses generics.
 *
 * Type parameters code can start to look verbose, but Kotlin has a very aggressive approach to type inference.
 * This type inference
 */
fun typeInference() {

    val aString = ""
    val aListOfString = listOf<String>()

    val maxVerbosity: Pair<out String, out List<String>> = Pair<String, List<String>>(aString, aListOfString)

    //first things first, we can see the compiler has "commented" out the types we attached to the pair above.
    //Let's go ahead and remove that, since that is purely duplicating the first part.
    val stillAlotOfVerbosity: Pair<out String, out List<String>> = Pair(aString, aListOfString)

    //Next we see the variance is complaining - this is because of Kotlin's Declaration-Site Variance!
    //We can remove that too, since it doesn't give us much.
    val lessVerbose : Pair<String, List<String>> = Pair(aString, aListOfString)

    //Now the compiler actually knows what the type is above without us explicitly declaring it, you can leave it
    //in for the sake of the programmer reading it, or if it's not helpful you can take it out as follows:
    val lookingGood = Pair(aString, aListOfString)

    //And if you really want to transcend:
    val transcendentalCode = aString to aListOfString
}


/**
 * FUN FACT - generic type inference would be severely undermined without declaration-site variance, if you always had to use
 * use-site variance then you would have to explicitly write the type out in order to add in your "out" or "in"
 * just like in the "maxVerbosity" val above.
 */

/**
 * So what are we getting here?
 *
 * Readability, readability and more readability! Although you can take it too far - always read it back to yourself
 * and put in explicit types if it becomes hard to reason about your program.
 */