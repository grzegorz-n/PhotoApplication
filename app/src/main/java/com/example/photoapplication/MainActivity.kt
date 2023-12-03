package com.example.photoapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //tworzę tablicę uprwanień
        val myPermissions: Array<String> = arrayOf(android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE)

        //tworzę zmienną która informuje czy mam uprawnienia
        var doPremissions = myPermissions.all {
            (ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED)
        }

        //Sprawdzam czy mam uprawnienia, jak nie to pytam o nie
        if (doPremissions) {
            //tu mam uprawnienia
            Toast.makeText(getApplicationContext(), "Mam uprawnienia", Toast.LENGTH_LONG).show()
        } else {
            // a tu się pytam o uprawnienia
            requestPermissions(myPermissions, 1)
        }
    }
}