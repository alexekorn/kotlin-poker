plugins {
    java
    kotlin ("jvm") version "1.4.32"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
    testImplementation(kotlin("test-junit5"))
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}

tasks {
    test {
        useJUnitPlatform()
    }
}

application {
    mainClass.set("com.alexkorn.Main")
}