package com.ishwar.intentservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ishwar.intentservices.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.startBtn.setOnClickListener {
//            Intent(this,MyIntentService::class.java).also {
//                startService(it)
//                binding.serviceText.text="Service running"
//            }
//        }
//
//        binding.stopBtn.setOnClickListener {
//            MyIntentService.stopService()
//            binding.serviceText.text="Service Stopped"
//        }

        binding.startBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                startService(it)
                binding.serviceText.text="Service running"
            }
        }

        binding.stopBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                stopService(it)
                binding.serviceText.text="Service Stopped"
            }
        }

        binding.sendDataBtn.setOnClickListener {
            Intent(this,MyService::class.java).also {
                val dataString =binding.editText.text.toString()
                it.putExtra("EXTRA_DATA",dataString)
                startService(it)

            }
        }
    }
}