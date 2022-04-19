package com.example.advertisingapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import kotlinx.android.synthetic.main.activity_advertising.*

class AdvertisingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertising)
        val timer = object : CountDownTimer(10 * 1000L, 1000) {
            override fun onFinish() {
                //mTimeCountTV.text = "已超时"
                startActivity(Intent().setClass(this@AdvertisingActivity,MainActivity::class.java))
                finish()
            }

            override fun onTick(millisUntilFinished: Long) {
                val mTime = millisUntilFinished / 1000
                val second = mTime % 60
                val minute = mTime / 60
                val minuteShow = if (minute < 10) "0$minute" else "$minute"
                val secondShow = if (second < 10) "0$second" else "$second"
                val showTime = "00:$minuteShow:$secondShow"
                //mTimeCountTV.text = showTime
                tv_timer.text="$showTime"
            }
        }.start()
        tv_timer.setOnClickListener {
            timer.cancel()
            timer.onFinish()
        }
    }
}