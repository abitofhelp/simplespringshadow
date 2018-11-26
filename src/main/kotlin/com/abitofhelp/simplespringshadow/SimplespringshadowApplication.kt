package com.abitofhelp.simplespringshadow

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class SimplespringshadowApplication

fun main(args: Array<String>) {
    runApplication<SimplespringshadowApplication>(*args)

    println("Howdy!")
}
