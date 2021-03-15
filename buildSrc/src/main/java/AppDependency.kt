import org.gradle.api.artifacts.dsl.DependencyHandler

object AppDependencies {
    // std lib
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    // android ui
    private const val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    private const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    private const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    private const val viewPager2 = "androidx.viewpager2:viewpager2:${Versions.viewPager2}"
    private const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    private const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    private const val navigationComponent = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // dependency injection
    const val hiltCompiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    private const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"

    // network
    private const val gson = "com.google.code.gson:gson:${Versions.gson}"
    private const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    private const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    private const val coroutines =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    private const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    private const val retrofitConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"


    // architecture components
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"
    private const val lifecycleLiveData =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    private const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"

    // test libs
    private const val junit = "junit:junit:${Versions.junit}"
    private const val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    val appLibraries = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(timber)
        add(coreKtx)
        add(fragmentKtx)
        add(activityKtx)
        add(appcompat)
        add(constraintLayout)
        add(viewPager2)
        add(cardView)
        add(glide)
        add(navigationComponent)
        add(navigationUi)
    }

    val appDependencyInjection = arrayListOf<String>().apply {
        add(hilt)
    }

    val appLifecycleLibraries = arrayListOf<String>().apply {
        add(lifecycleLiveData)
        add(lifecycleViewModel)
    }

    val appNetworkLibraries = arrayListOf<String>().apply {
        add(gson)
        add(okhttp)
        add(okhttpLoggingInterceptor)
        add(coroutines)
        add(retrofit)
        add(retrofitConverter)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }
}

// util functions for adding the different type dependencies from build.gradle file
fun DependencyHandler.kapt(vararg dependencies: String) {
    dependencies.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementation(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementation(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}