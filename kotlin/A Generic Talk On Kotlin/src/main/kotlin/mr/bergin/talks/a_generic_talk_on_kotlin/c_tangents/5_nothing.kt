package mr.bergin.talks.a_generic_talk_on_kotlin.c_tangents

//Talk about how nothing allows us to use one type to represent all empty lists in a typesafe way.
//You could just cast, and it would all work fine, or you could communicate with the compiler that you
//have a list of Nothing, and it is then happy to use covariance to assign anything to an empty list.

fun foo() {

}