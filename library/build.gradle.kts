import com.vanniktech.maven.publish.SonatypeHost
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
  alias(libs.plugins.kotlinMultiplatform)
  alias(libs.plugins.androidLibrary)
  alias(libs.plugins.vanniktech.mavenPublish)
}

group = "io.github.lukmccall"
version = "1.0.0"

kotlin {
  jvm()
  androidTarget {
    publishLibraryVariants("release")
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    compilerOptions {
      jvmTarget.set(JvmTarget.JVM_11)
    }
  }
  iosX64()
  iosArm64()
  iosSimulatorArm64()
  linuxX64()

  sourceSets {
    val commonMain by getting {
      dependencies {
        //put your multiplatform dependencies here
      }
    }
  }
}

android {
  namespace = "io.github.lukmccall"
  compileSdk = libs.versions.android.compileSdk.get().toInt()
  defaultConfig {
    minSdk = libs.versions.android.minSdk.get().toInt()
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
}

mavenPublishing {
  publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

  signAllPublications()

  coordinates(group.toString(), "radix-colors", version.toString())

  pom {
    name = "Radix UI Colors"
    description = "A port of `@radix-ui/colors` npm package for Kotlin."
    inceptionYear = "2025"
    url = "https://github.com/kotlin/multiplatform-library-template/"
    licenses {
      license {
        name = "The MIT License"
        url = "https://opensource.org/license/mit"
        distribution = "https://opensource.org/license/mit"
      }
    }
    developers {
      developer {
        id = "lukmccall"
        name = "Łukasz Kosmaty"
        url = "https://github.com/lukmccall"
      }
    }
    scm {
      url = "https://github.com/lukmccall/radix-colors"
      connection = "scm:git:git://github.com/lukmccall/radix-colors.git"
      developerConnection = "scm:git:ssh://github.com/lukmccall/radix-colors.git"
    }
  }
}
