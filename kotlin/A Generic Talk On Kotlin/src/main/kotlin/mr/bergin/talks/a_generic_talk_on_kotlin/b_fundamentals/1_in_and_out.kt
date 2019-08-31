package mr.bergin.talks.a_generic_talk_on_kotlin.b_fundamentals


/**
 * Here we talk about the variance modifiers: in and out.
 *
 * These allow you to place restrictions on the members of a generic type.
 *
 * In exchange for this you gain flexibility with what the generic type parameter can be.
 */

/**
 * Simplest example: neither in nor out.
 * In english, this means we have a list of numbers.
 */
fun neitherInNorOut() {

    var listOfNumbers: MutableList<Number> = mutableListOf<Number>()

    //we have no restrictions on how we can use this type :)
    listOfNumbers.add(42)
    val result: Number = listOfNumbers.first()

    //but we have no flexibility of assigning it :(
    listOfNumbers = mutableListOf<Any>()
    listOfNumbers = mutableListOf<Int>()
}

/**
 * In variance.
 * In english this means we have a list and all we know about it is it can have numbers put in it.
 */
fun `in`() {
    var canPutNumbersIn : MutableList<in Number> = mutableListOf<Number>()

    //we have a restriction on what we are allowed to take out now:
    canPutNumbersIn.add(42)
    val result: Any? = canPutNumbersIn.first() //can't take out a number, has to be Any?

    //but now we can be flexible on what we can assign:
    canPutNumbersIn = mutableListOf<Any>() //a list of anything can have numbers go in, so this is fine!
    canPutNumbersIn = mutableListOf<Int>() //there are number types that wouldn't go in here, such as Double :(
}

/**
 * Out variance.
 * In english this means we have a list, all we know about it is we can take numbers out.
 */
fun `out`() {
    var canTakeNumbersOut : MutableList<out Number> = mutableListOf<Number>()

    //we have a restriction on what we are allowed to put in now:
    canTakeNumbersOut.add(42)
    val result: Number = canTakeNumbersOut.first()

    //but now we can be flexible on what we can assign:
    canTakeNumbersOut = mutableListOf<Any>() // A list of Any could have Strings in it.
    canTakeNumbersOut = mutableListOf<Int>() // A List of Ints, can of course produce you a number.
}

/**
 * Here's a quick example: using "out" here allows us to be flexible types later on:
 */
fun <K> toMutableList(source: Array<out K>): MutableList<K> {
    val toReturn = mutableListOf<K>()
    for (k in source) {
        toReturn.add(k)
    }
    return toReturn
}

val arrayOfInts = arrayOf<Int>()
val listOfAny: MutableList<Number> = toMutableList(arrayOfInts) //this only works because we used "out"!!


/**
 * Let's reflect on the benefits of in and out, it gives us:
 *
 * Flexibility - if we know our function only consumes or only produces K, then we can allow callers to use more types!
 */