package com.example.myapplication1

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity() {
    private val mHandler = MyHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mHandler.sendEmptyMessage(0)
    }

    private class MyHandler constructor(activity: MainActivity) : Handler() {
        private val mActivity: WeakReference<MainActivity> = WeakReference(activity)

        override fun handleMessage(msg: Message) {
            mActivity.get() ?: return
            if (msg.what == 0) {
                Log.d(TAG, "what is 0.")
            }
        }

        companion object {
            private const val TAG = "MyHandler"
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
