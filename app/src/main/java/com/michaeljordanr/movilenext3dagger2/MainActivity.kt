package com.michaeljordanr.movilenext3dagger2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val component = DaggerTwitterComponent.builder()
            .twitterModule(TwitterModule("Michael"))
            .build()

        val tweeter = component.tweeter()
        val timeline = component.timeline()
    }
}
