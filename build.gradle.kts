import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    //application
    //idea
    java
    kotlin("jvm") version "1.3.10"

    id("com.github.johnrengelman.shadow") version "4.0.3"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    id("org.springframework.boot") version "2.1.0.RELEASE"
}

group = "com.abitofhelp"
version = "1.0.0"

repositories {
    maven("https://plugins.gradle.org/m2/")
    maven("https://repo.spring.io/milestone")
    maven("https://repo.spring.io/snapshot")
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Greenwich.BUILD-SNAPSHOT")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

///////////////////////////////////////////////////////////////////////
// This task must be added to the build.gradle.kts file
// in order to create a shadowjar containing the required information.
///////////////////////////////////////////////////////////////////////

tasks {
    withType<ShadowJar> {
        manifest.attributes.apply {

            ///////////////////////////////////////////////////////////
            // The following attributes apply to the archive/jar file
            // that is being created and not the manifest.
            ///////////////////////////////////////////////////////////

            baseName = "simplespringshadow"

            // A description about the archive/jar being created;
            // I couldn"t find it being applied to an archive/jar.
            // description = "A simple app to determine how to configure shadowjar with Kotlin DSL in Gradle."

            // The base name of the archive/jar being created
            // archiveName = "thearchivename"

            // The directory path for the archive/jar being created
            // destinationDir = File("")

            // The extension part of the archive/jar name
            // extension = "JAR"

            // The appendix part of the archive/jar name
            // appendix = "abc"

            // The classifier part of the archive/jar name
            classifier = "all"

            // The version part of the archive/jar name
            version = "1.0.0"

            ///////////////////////////////////////////////////////////
            // The following attributes apply to the mainfest for the
            // archive/jar being created.
            ///////////////////////////////////////////////////////////
            manifest {
                attributes(
                        mutableMapOf<String, String>(
                                "Base-Name" to baseName,
                                "Main-Class" to "com.abitofhelp.simplespringshadow.SimplespringshadowApplicationKt",
                                "Start-Class" to "",
                                "Implementation-Title" to "I am a title.",
                                "Implementation-Version" to version
                        )
                )
            }
        }
    }
}


