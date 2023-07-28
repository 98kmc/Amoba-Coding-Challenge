
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    id ("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.example.amobacodingchallenge"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.amobacodingchallenge"
        minSdk = 29
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        viewBinding = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    sourceSets {
        getByName("main") {
            res.srcDirs(
                "src/main/res/layouts/login_screen",
                "src/main/res/layouts/patient_list_screen",
                "src/main/res"
            )
        }
    }
}

dependencies {

    implementation("androidx.compose.animation:animation:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.compose.runtime:runtime:1.4.3")
    implementation("androidx.compose.ui:ui:1.4.3")

    //Kotlin
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.10")

    //UI
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("androidx.navigation:navigation-fragment-ktx:2.6.0")
    implementation("androidx.navigation:navigation-ui-ktx:2.6.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")

    //Maps
    implementation("com.google.maps.android:maps-compose:1.0.0")
    implementation("com.google.android.gms:play-services-maps:18.1.0")

    //Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")


    //Hilt 2
    implementation("com.google.dagger:hilt-android:2.46.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.4.3")
    kapt("com.google.dagger:hilt-android-compiler:2.46.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.14.2")
    kapt("com.github.bumptech.glide:compiler:4.14.2")



    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    //Okhttp3
    implementation("com.squareup.okhttp3:okhttp:4.10.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
}