plugins {
    id("java-library")
    id("edu.wpi.first.GradleRIO") version "2024.1.1-beta-3"

}

group = "org.stealthrobotics.stealthylib.frc"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    gradlePluginPortal()

    maven {
        url = uri("https://frcmaven.wpi.edu/artifactory/release/")
    }

    // CTRE
    maven {
        url = uri("https://devsite.ctr-electronics.com/maven/release/")
    }

    // REV
    maven {
        url = uri("https://maven.revrobotics.com/")
    }

}

dependencies {
    implementation(project(":core"))

    implementation("edu.wpi.first.cscore:cscore-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.cameraserver:cameraserver-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.ntcore:ntcore-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.wpilibj:wpilibj-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.wpiutil:wpiutil-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.wpimath:wpimath-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.wpiunits:wpiunits-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.hal:hal-java:2024.1.1-beta-3")
    implementation("edu.wpi.first.wpilibNewCommands:wpilibNewCommands-java:2024.1.1-beta-3")

    implementation("org.ejml:ejml-simple:0.41")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.12.7")
    implementation("com.fasterxml.jackson.core:jackson-core:2.12.7")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.7.1")
    implementation("edu.wpi.first.thirdparty.frc2023.opencv:opencv-java:4.6.0-2")

    // CTRE Phoenix (Vendor Lib)
    implementation("com.ctre.phoenix:api-java:5.31.0")
    implementation("com.ctre.phoenix:wpiapi-java:5.31.0")

    // REV Lib (Vendor Lib)
    implementation("com.revrobotics.frc:REVLib-java:2023.1.3")

    // Pathplanner (Vendor Lib)
    implementation("com.pathplanner.lib.PathplannerLib-java:2024.0.0-beta-5.1")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11

    withSourcesJar()
    withJavadocJar()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.named("javadocJar") {
    dependsOn("javadoc")
}