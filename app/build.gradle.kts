plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Configuration.compileSdk)
    buildToolsVersion = Configuration.buildTool_version

    defaultConfig {
        applicationId = Configuration.applicationId
        minSdkVersion(Configuration.minSdk)
        targetSdkVersion(Configuration.targetSdk)
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
        dataBinding = true
    }
}

dependencies {

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin_version}")
    implementation("androidx.core:core-ktx:1.5.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.multidex:multidex:2.0.1")
    testImplementation("junit:junit:4.+")
    androidTestImplementation("androidx.test.ext:junit:1.1.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")

    //retrofit
    implementation(Dependencies.retrofit)
    implementation(Dependencies.gson)

    //koin
    implementation(Dependencies.koin_core)
    implementation(Dependencies.koin_android)

    //glide
    implementation(Dependencies.glide)
    kapt(Dependencies.glide_compiler)

    //coroutines
    implementation(Dependencies.coroutine)
    implementation(Dependencies.viewmodel)

    //navigation component
    implementation(Dependencies.navigation_fragment)
    implementation(Dependencies.navigation_ui)
}
