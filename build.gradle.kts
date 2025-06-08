plugins {
    kotlin("js") version "1.8.10"
    id("org.gradle.base")
}

group = "dev.chrisgaunt"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
            binaries.executable()
        }
    }
}
dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.467")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.467")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.10.5-pre.467")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.3.0-pre.467")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:4.1.2-pre.467")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:7.2.6-pre.467")
}

// Task to prepare files for GitHub Pages
tasks.register<Copy>("deployToGitHubPages") {
    dependsOn("browserDistribution")
    from("$buildDir/distributions")
    into("$rootDir/docs")
}

// Create an empty .nojekyll file to prevent GitHub from ignoring files that begin with an underscore
tasks.register<Exec>("createNojekyllFile") {
    dependsOn("deployToGitHubPages")
    commandLine("touch", "$rootDir/docs/.nojekyll")
}

// Make the build task depend on our GitHub Pages deployment tasks
tasks.named("build") {
    dependsOn("createNojekyllFile")
}
