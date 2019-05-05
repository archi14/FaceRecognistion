package com.example.archi.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.TextureView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btn);
        val textureview = findViewById<TextureView>(R.id.textureview);

    }
}
