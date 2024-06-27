plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("com.google.devtools.ksp") version "1.9.0-1.0.11" // Make sure this version is compatible with your Kotlin version

    //Kotlinx Serialization
    kotlin("plugin.serialization") version "1.9.10"

}

android {
    namespace = "com.example.kmmsocial.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.kmmsocial.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    applicationVariants.all {
        addJavaSourceFoldersToModel(
            layout.buildDirectory.dir("generated/ksp/$name/kotlin").get().asFile
        )
    }


}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)

    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)
    implementation("androidx.compose.foundation:foundation:1.6.8")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("io.github.raamcosta.compose-destinations:core:1.10.2")
    ksp("io.github.raamcosta.compose-destinations:ksp:1.8.38-beta")

    implementation("androidx.core:core-splashscreen:1.0.1")

    implementation("io.insert-koin:koin-androidx-compose:3.4.1")

    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.6.1")

    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")

    implementation("io.coil-kt:coil-compose:2.6.0")
}