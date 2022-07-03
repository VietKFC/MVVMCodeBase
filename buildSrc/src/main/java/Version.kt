object Version {
    const val kotlin_version = "1.5.20"
    const val koin_version = "3.2.0"
    const val navigation_component_version = "2.4.2"
    const val coroutine_version = "1.6.1"
    const val viewmodel_version = "2.4.1"
    const val glide_version = "4.12.0"
    const val retrofit_version = "2.9.0"
}

object Dependencies {
    const val koin_core = "io.insert-koin:koin-core:${Version.koin_version}"
    const val koin_android = "io.insert-koin:koin-android:${Version.koin_version}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit_version}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Version.retrofit_version}"

    const val glide = "com.github.bumptech.glide:glide:${Version.glide_version}"
    const val glide_compiler = "com.github.bumptech.glide:compiler:${Version.glide_version}"

    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine_version}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewmodel_version}"

    const val navigation_fragment =
        "androidx.navigation:navigation-fragment-ktx:${Version.navigation_component_version}"
    const val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Version.navigation_component_version}"


}

object Configuration {
    const val applicationId = "com.example.mvvmcodebase"
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val versionCode = 1
    const val buildTool_version = "30.0.3"
    const val versionName = "1.0"
}
