package com.zyh.ipc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val test = intent.getSerializableExtra("key") as ATest

        Log.i("yh", "onCreate: $test")
    }
}