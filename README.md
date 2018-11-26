# SimpleSpringShadow

There seems to be some confusion about generating a ShadowJar's manifest file when using Kotlin DSL, 
so this simple Spring application shows how I am doing it.  If my method is not the idiomatic way to accomplish
this task, please post your suggestions.
 
SimpleSpringShdaow is a Kotlin application that properly builds a ShadowJar (aka, "fat-jar, uber-jar") 
using Gradle and Kotlin DSL.  

The following command will launch the ShadowJar and write "Howdy!" on the terminal: 

java -jar simplespringshadow-1.0.0-all.jar


