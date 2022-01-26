plugins {
    kotlin( "jvm" ) version "1.6.10"
    id( "java-gradle-plugin" )
    id( "maven-publish" )
}

group = "de.deroli.gradle"
version = "0.1.0"

repositories {
    mavenCentral()
    mavenLocal()
}

gradlePlugin {
    plugins {
        create( "minecraft-modpack-gradle-plugin") {
            id = "minecraft-modpack-gradle-plugin"
            implementationClass = "de.deroli.gradle.plugins.minecraft.ModpackGradlePlugin"
        }
    }
}

dependencies {
    implementation( kotlin( "stdlib" ) )
    implementation( "com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1" )

    testImplementation( "org.junit.jupiter:junit-jupiter-api:5.8.2" )

    testRuntimeOnly( "org.junit.jupiter:junit-jupiter-engine" )
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}