plugins {
    id("com.android.library")
}

group = "org.stealthrobotics.stealthylib"
version = "0.1.0-beta"

android {
    namespace = "org.stealthrobotics.stealthylib"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(project(":core"))

    // TODO: Decide Which FTC Dependencies To Keep
    implementation ("org.firstinspires.ftc:Inspection:10.1.0")
    implementation ("org.firstinspires.ftc:Blocks:10.1.0")
    implementation ("org.firstinspires.ftc:Tfod:9.0.1")
    implementation ("org.firstinspires.ftc:RobotCore:10.1.0")
    implementation ("org.firstinspires.ftc:RobotServer:10.1.0")
    implementation ("org.firstinspires.ftc:OnBotJava:10.1.0")
    implementation ("org.firstinspires.ftc:Hardware:10.1.0")
    implementation ("org.firstinspires.ftc:FtcCommon:10.1.0")
    implementation ("org.firstinspires.ftc:Vision:10.1.0")
    implementation ("org.firstinspires.ftc:gameAssets-CenterStage:1.0.0")
    implementation ("org.tensorflow:tensorflow-lite-task-vision:0.4.3")
    runtimeOnly ("org.tensorflow:tensorflow-lite:2.12.0")
    implementation ("androidx.appcompat:appcompat:1.7.0")

    implementation ("org.ftclib.ftclib:core:2.1.1") // core

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()

                from(components["release"])
            }
        }
    }
}