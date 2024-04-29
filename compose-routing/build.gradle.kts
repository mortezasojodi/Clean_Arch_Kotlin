plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "com.msa.compose.routing"
    compileSdk = 34

    defaultConfig {
//        minSdk = 21
//        targetSdk = 33
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }

    sourceSets.all {
        kotlin.srcDir("src/$name/kotlin")
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }

    kotlinOptions {
        freeCompilerArgs += "-Xcontext-receivers"
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.compose.activity)
    implementation(libs.compose.foundation)
}
