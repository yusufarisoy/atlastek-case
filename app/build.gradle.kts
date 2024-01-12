plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    kotlin("kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.yusufarisoy.atlastekcase"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yusufarisoy.atlastekcase"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)
    implementation(Libs.material)
    implementation(Libs.fragment)
    implementation(Libs.constraintLayout)
    // Hilt
    implementation(Libs.hiltAndroid)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    kapt(Libs.hiltAndroidCompiler)
    // Retrofit
    implementation(Libs.retrofit)
    implementation(Libs.retrofitConverterGson)
    implementation(Libs.gson)
    // Lifecycle
    implementation(Libs.lifecycleCommon)
    implementation(Libs.lifecycleRunTime)
    implementation(Libs.lifecycleViewModel)
    implementation(Libs.lifecycleLiveData)
    // Coroutines
    implementation(Libs.coroutinesCore)
    implementation(Libs.coroutinesAndroid)
    // Glide
    implementation(Libs.glide)
    // Paging
    implementation(Libs.paging)
    // LegacySupport
    implementation(Libs.legacySupport)
    // Test
    testImplementation(Libs.junit)
    androidTestImplementation(Libs.extJunit)
    androidTestImplementation(Libs.espressoCore)
}