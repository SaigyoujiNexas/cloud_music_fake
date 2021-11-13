plugins {
    id("com.android.application")
    id("kotlin-android")
    id("com.google.devtools.ksp") version "1.5.30-1.0.0-beta09"
    kotlin("plugin.serialization") version "1.5.31"
}

android {
    compileSdk = 31

    defaultConfig {
        applicationId = "com.saigyouji.cloudmusic"
        minSdk = 25
        targetSdk = 31
        compileSdk = 31
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility(1.8)
        targetCompatibility(1.8)
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation("androidx.core:core-splashscreen:1.0.0-alpha02")
    implementation("androidx.room:room-ktx:2.4.0-beta01")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-common-java8:2.4.0")

    implementation("com.google.code.gson:gson:2.8.9")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.navigation:navigation-ui-ktx:2.4.0-beta02")
    implementation("androidx.navigation:navigation-fragment-ktx:2.4.0-beta02")
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.4.0-beta02")

    androidTestImplementation("androidx.room:room-testing:2.4.0-beta01")
    androidTestImplementation("androidx.navigation:navigation-testing:2.4.0-beta02")

    ksp("androidx.room:room-compiler:2.4.0-beta01")
    testImplementation("junit:junit:4.13.2")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}