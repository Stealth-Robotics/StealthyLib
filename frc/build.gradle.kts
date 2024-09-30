plugins {
    id("java-library")
    id("edu.wpi.first.GradleRIO") version "2024.3.2"

}

group = "org.stealthrobotics.stealthylib"
version = "0.1.0-beta"

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

    // PathPlanner
    maven {
        url = uri("https://3015rangerrobotics.github.io/pathplannerlib/repo")
    }
}

dependencies {
    implementation(project(":core"))

    implementation("edu.wpi.first.cscore:cscore-java:2024.3.1")
    implementation("edu.wpi.first.cameraserver:cameraserver-java:2024.3.1")
    implementation("edu.wpi.first.ntcore:ntcore-java:2024.3.1")
    implementation("edu.wpi.first.wpilibj:wpilibj-java:2024.3.1")
    implementation("edu.wpi.first.wpiutil:wpiutil-java:2024.3.1")
    implementation("edu.wpi.first.wpimath:wpimath-java:2024.3.1")
    implementation("edu.wpi.first.wpiunits:wpiunits-java:2024.3.1")
    implementation("edu.wpi.first.hal:hal-java:2024.3.1")
    implementation("edu.wpi.first.wpilibNewCommands:wpilibNewCommands-java:2024.3.1")

    implementation("org.ejml:ejml-simple:0.43.1")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("edu.wpi.first.thirdparty.frc2023.opencv:opencv-java:4.6.0-2")

    // CTRE Phoenix (Vendor Lib)
    implementation("com.ctre.phoenix:api-java:5.33.1")
    implementation("com.ctre.phoenix:wpiapi-java:5.33.1")

    implementation("com.ctre.phoenix6:wpiapi-java:24.2.0")

    // REV Lib (Vendor Lib)
    implementation("com.revrobotics.frc:REVLib-java:2023.1.3")

    // Path Planner (Vendor Lib)
    implementation("com.pathplanner.lib:PathplannerLib-java:2024.2.8")

    testImplementation(platform("org.junit:junit-bom:5.9.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    withSourcesJar()
    withJavadocJar()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}