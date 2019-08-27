import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.3.50"
}
apply {
    plugin("kotlin")
}
dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("stdlib-jdk8"))
    compile(kotlin("reflect"))
}
repositories {
    mavenCentral()
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}