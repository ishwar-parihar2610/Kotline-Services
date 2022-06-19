package com.ishwar.intentservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    val TAG = "MyService"
    var i : Int=0
    init {

        Log.d(TAG, "Service is Running: ")

    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, "onStartCommand: ${dataString}")

        }

        return START_STICKY
    }
}