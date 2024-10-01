# Stealthy Lib

![Core Module Build](https://github.com/Stealth-Robotics/StealthyLib/actions/workflows/build-core.yml/badge.svg)
![FRC Module Build](https://github.com/Stealth-Robotics/StealthyLib/actions/workflows/build-frc.yml/badge.svg)
![Core FTC Build](https://github.com/Stealth-Robotics/StealthyLib/actions/workflows/build-ftc.yml/badge.svg)<br>
[![](https://jitpack.io/v/Stealth-Robotics/StealthyLib.svg)](https://jitpack.io/#Stealth-Robotics/StealthyLib)

Stealthy Lib is a library created, mantained, and used by Cedarcrest High School's FIRST Team, which includes:

-   **FIRST Robotics Competition Team 4089 - Stealth Robotics**
    -   [Team Website](https://www.stealthrobotics.com)
    -   [4089 @ The Blue Alliance](https://www.thebluealliance.com/team/4089)
    -   [4089 @ FIRST Inspires](https://frc-events.firstinspires.org/team/4089)
-   [FIRST Tech Challenge Team 7759 - Autonomous Prime](https://ftc-events.firstinspires.org/team/7759)
-   [FIRST Tech Challenge Team 7760 - Mishap](https://ftc-events.firstinspires.org/team/7760)
-   [FIRST Tech Challenge Team 13648 - Jankbot](https://ftc-events.firstinspires.org/team/13648)
-   [FIRST Tech Challenge Team 22152 - Smelt](https://ftc-events.firstinspires.org/team/22152)
-   [FIRST Tech Challenge Team 22153 - Xero](https://ftc-events.firstinspires.org/team/22153)

This library includes code that is consistently reused throughout multiple seasons, across multiple teams, and that tends to be useful for FTC and FRC codebases.

---

## Structure

This library is structured as a Gradle project, with the following modules:

-   `core`: The core module that contains league agnostic code.
-   `ftc`: The FTC-specific module, which contains code that is useful for FTC codebases.
-   `frc`: The FRC-specific module, which contains code that is useful for FRC codebases.

Please make sure you are using the correct modules for your codebase.

---

## Installation

-   [FTC Installation](#ftc-installation)
-   [FRC Installation](#frc-installation)

### FTC Installation

1.  Open your FTC SDK project in Android Studio.
2.  Open `build.common.gradle` file of your project.
3.  Scroll to the bottom where you should find a `dependencies` block. Here add the following to the `dependencies` block:
    ```groovy
    maven { url 'https://jitpack.io' }
    ```
4.  Open the `build.gradle` file of your `TeamCode` module (This is the `build.gradle` in the `TeamCode` folder.
5.  Go to the bottom of the file, and add the following to the `dependencies` block.

    ```groovy
    implementation 'com.github.Stealth-Robotics.StealthyLib:core:v1.0.0' // core lib
    implementation 'com.github.Stealth-Robotics.StealthyLib:ftc:v1.0.0' // ftc lib
    ```

    Add the line under already existing dependencies if the `dependencies` block already exists. If it doesn't exist, you can create one similar to what is shown below. It should look something like this:

    ```groovy
    dependencies {
      implementation '...' // example of an already existing dependencies

      implementation 'com.github.Stealth-Robotics.StealthyLib:core:v0.1.0-beta' // core lib
      implementation 'com.github.Stealth-Robotics.StealthyLib:ftc:v0.1.0-beta' // ftc lib
    }
    ```

6.  In `build.common.gradle`, change the minSdkVersion from 23 to 24:
    ```groovy
    defaultConfig {
      applicationId 'com.qualcomm.ftcrobotcontroller'
     	minSdkVersion 24
     	targetSdkVersion 28
    }
    ```
7.  Ensure your Java version is set to 8. This should already be the case with the latest SDK.
    If not, you will need to change your Java version. Scroll down in `build.common.gradle` until you find the `compileOptions` block.
    ```groovy
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_7
        targetCompatibility JavaVersion.VERSION_1_7
    }
    ```
    Change the 7 to an 8 like so:
    ```groovy
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    ```
8.  Perform a Gradle sync your project. You should now be able to use the library in your project files (inside `TeamCode`)!

**NOTE:** If your module has a few dependencies, you might have an error related to multidex on building the project. This is caused by the project exceeding the limit for imports enforced by Android Studio. To solve this, add `multiDexEnabled true` to the below location inside the `build.common.gradle` file.

```groovy
defaultConfig {
    applicationId 'com.qualcomm.ftcrobotcontroller'
    minSdkVersion 24
    targetSdkVersion 28

    multiDexEnabled true
}
```

### FRC Installation

Open your FRC project in VSCode, and follow the instructions below.

1.  [Install The Following Vendor Libraries](https://docs.wpilib.org/en/stable/docs/software/vscode-overview/3rd-party-libraries.html#installing-libraries) (WPILib Plugin → Manage Vendor Libraries → Install New Libraries (Online))
    -   CTRE Phoenix (Phoenix 5 & Phoenix 6
        -   https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2024-beta-latest.json
        -   https://maven.ctr-electronics.com/release/com/ctre/phoenix6/latest/Phoenix6-frc2024-beta-latest.json
    -   REV Robotics
        -   https://software-metadata.revrobotics.com/REVLib-2023.json
    -   PathPlanner
        -   https://3015rangerrobotics.github.io/pathplannerlib/PathplannerLib.json
2.  Open the `build.gradle` file of your project.
3.  After the `plugins` block, add the following:
    ```groovy
    repositories {
        maven { url 'https://jitpack.io' }
    }
    ```
4.  Add the following to the `dependencies` block in the `build.gradle` file.

    ```groovy
    implementation 'com.github.Stealth-Robotics.StealthyLib:core:v0.1.0-beta' // core lib
    implementation 'com.github.Stealth-Robotics.StealthyLib:frc:v0.1.0-beta' // frc lib
    ```

    Add the line under already existing dependencies if the `dependencies` block already exists. If it doesn't exist, you can create one similar to what is shown below. It should look something like this:

    ```groovy
    dependencies {
      implementation '...' // example of an already existing dependencies

      implementation 'com.github.Stealth-Robotics.StealthyLib:core:v0.1.0-beta' // core lib
      implementation 'com.github.Stealth-Robotics.StealthyLib:frc:v0.1.0-beta' // frc lib
    }
    ```

5.  Build your project through the WPILib plugin (WPILib Plugin → Build Robot Code). You should now be able to use the library in your project files!

---
