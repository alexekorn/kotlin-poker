plugins {
    kotlin("jvm") version "1.4.32"
    application
    id("org.jmailen.kotlinter") version "3.4.0"
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

application {
    mainClass.set("com.alexkorn.Main")
}