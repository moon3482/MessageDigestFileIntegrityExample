import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
}

group = "me.moon3"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation ("io.reactivex.rxjava2:rxjava:2.2.6")
    implementation ("io.reactivex.rxjava2:rxkotlin:2.3.0")
    implementation("org.reactivestreams:reactive-streams:1.0.3")

}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}