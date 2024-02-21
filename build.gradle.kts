plugins {
    kotlin("jvm") version "1.9.21"
    kotlin("plugin.serialization") version "1.9.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"
val allureVersion = "2.24.0"

val aspectJVersion = "1.9.20.1"

// Define configuration for AspectJ agent
val agent: Configuration by configurations.creating {
    isCanBeConsumed = true
    isCanBeResolved = true
}


repositories {
    mavenCentral()
}

dependencies {
    agent("org.aspectj:aspectjweaver:$aspectJVersion")

    testImplementation(platform("org.jetbrains.kotlin:kotlin-bom:1.9.21"))
    testImplementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    implementation("com.microsoft.playwright:playwright:1.40.0")


    testImplementation(platform("io.qameta.allure:allure-bom:$allureVersion"))
    implementation("io.qameta.allure:allure-java-commons:2.25.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

    testImplementation("io.qameta.allure:allure-junit5")

    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter-api")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")

    testImplementation("org.slf4j:slf4j-simple:2.0.9")

}

tasks.test {
    useJUnitPlatform()
    delete("allure-results")
    jvmArgs = listOf(
        "-javaagent:${agent.singleFile}",
    )
    //environment("SELENIUM_REMOTE_URL","http://172.19.253.75:4444")
    systemProperties["stand"] = System.getProperty("stand")
    systemProperties["junit.jupiter.execution.parallel.enabled"] = true
    systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"

    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).takeIf { it > 0 } ?: 1
}
kotlin {
    jvmToolchain(8)
}