object Dependencies {
    object Normal {
        private const val androidCore = "androidx.core:core-ktx:1.9.0"
        private const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        private const val material = "com.google.android.material:material:1.7.0"
        private const val constraint = "androidx.constraintlayout:constraintlayout:2.1.4"
        val lists = listOf(androidCore, appCompat, material, constraint)
    }

    object UnitTesting {
        private const val junit = "junit:junit:4.13.2"
        val list = listOf(junit)
    }

    object Instrumentation {
        private const val junit = "androidx.test.ext:junit:1.1.4"
        private const val espressoCore = "androidx.test.espresso:espresso-core:3.5.0"
        val list = listOf(junit, espressoCore)
    }
}