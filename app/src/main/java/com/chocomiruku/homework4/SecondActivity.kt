package com.chocomiruku.homework4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.chocomiruku.homework4.databinding.ActivitySecondBinding

const val KEY_IMG_NUM = "key_img_num"

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnFirst.setOnClickListener {
            val intent = Intent().putExtra(KEY_IMG_NUM, 1)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnSecond.setOnClickListener {
            val intent = Intent().putExtra(KEY_IMG_NUM, 2)
            setResult(RESULT_OK, intent)
            finish()
        }

        binding.btnThird.setOnClickListener {
            val intent = Intent().putExtra(KEY_IMG_NUM, 3)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}