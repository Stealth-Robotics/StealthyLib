buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.3")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "maven-publish")

    repositories() {
        mavenLocal()
    }

    tasks {
        withType<Jar> {
            enabled = true
        }
    }

    afterEvaluate {
        if (project.hasProperty("android"))
        {
            project.configure<PublishingExtension> {
                publications {
                    findByName("release")?.let { releasePublication ->
                        add(releasePublication)
                    }
                }
            }
        }
        else {
            configure<PublishingExtension> {
                publications {
                    create<MavenPublication>("maven") {
                        groupId = project.group.toString()
                        artifactId = project.name
                        version = project.version.toString()

                        from(components["java"])
                    }
                }
            }
        }
    }
}