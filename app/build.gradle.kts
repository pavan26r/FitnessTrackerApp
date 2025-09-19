plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    id("com.google.dagger.hilt.android")
}
android {
    namespace = "com.example.healthify"
    compileSdk = 36
    defaultConfig {
        applicationId = "com.example.healthify"
        minSdk = 25
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    // setting dependencies for

    implementation(libs.retrofit.v300)
    implementation(libs.converter.gson.v300)
    implementation(libs.coil.compose)
    implementation(libs.kotlinx.coroutines.android.v173)

// CameraX dependencies (adjust version if needed)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
    implementation(libs.androidx.camera.view)
    implementation(libs.retrofit.v290)
    implementation(libs.converter.gson.v290)
    implementation(libs.okhttp.v4100)
    // api for gemini ->
    implementation(libs.generativeai)
    implementation(libs.androidx.material3.v121)
    implementation(libs.generativeai)

    // Kotlin Coroutines (already mostly hota hai Compose project me)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Jetpack Lifecycle (ViewModel + Scope support ke liye)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx.v284)
    //hilt ->
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    // For Hilt + ViewModel
    implementation(libs.androidx.hilt.navigation.compose)
    // material1 dependencies ->
    implementation(libs.material3)
// Material2 (for SwipeToDismiss)
    implementation(libs.androidx.material)
    implementation(libs.navigation.compose)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)   // Gson converter
    // OR
    // implementation(libs.retrofit.moshi) // Agar Moshi use karna hai
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.navigation.compose)
    // Annotation processing via KSP:
    ksp(libs.room.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}