package com.chocomiruku.homework4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.chocomiruku.homework4.databinding.ActivityMainBinding

const val KEY_RES_ID = "key_res_id"

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                data?.let {
                    when (data.getIntExtra(KEY_IMG_NUM, 0)) {
                        1 -> {
                            binding.img.setImageResource(R.drawable.one)
                            binding.img.tag = R.drawable.one
                        }
                        2 -> {
                            binding.img.setImageResource(R.drawable.two)
                            binding.img.tag = R.drawable.two
                        }
                        3 -> {
                            binding.img.setImageResource(R.drawable.three)
                            binding.img.tag = R.drawable.three
                        }
                    }
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val imgResId = savedInstanceState?.getInt(KEY_RES_ID) ?: R.drawable.two
        binding.img.tag = imgResId
        binding.img.setImageResource(imgResId)

        binding.btnNavigateToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.img.tag?.let {
            outState.putInt(KEY_RES_ID, binding.img.tag as Int)
        }
    }
}