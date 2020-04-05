package com.dicoding.picodiploma.dicoding_first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var widthEt: EditText
    private lateinit var heightEt: EditText
    private lateinit var lengthEt: EditText
    private lateinit var calculateBtn: Button
    private lateinit var resTv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        widthEt = findViewById(R.id.et_lebar)
        heightEt = findViewById(R.id.et_tinggi)
        lengthEt = findViewById(R.id.et_panjang)

        calculateBtn = findViewById(R.id.btn_calculate)
        resTv = findViewById(R.id.tv_result)

        calculateBtn.setOnClickListener(this)

        if (savedInstanceState != null){
            val res = savedInstanceState.getString(STATE_RESULT) as String
            resTv.text = res
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.btn_calculate){
            val panjang = lengthEt.text.toString().trim()
            val lebar = widthEt.text.toString().trim()
            val tinggi = heightEt.text.toString().trim()

            var empty = false
            var invalidDouble = false

            if(panjang.isEmpty()){
                empty = true
                lengthEt.error = "Field tidak boleh kosong !"
            }

            if(lebar.isEmpty()){
                empty = true
                widthEt.error = "Field tidak boleh kosong !"
            }

            if(tinggi.isEmpty()){
                empty = true
                heightEt.error = "Field tidak boleh kosong !"
            }

            val panjangNew = toDouble(panjang)
            val lebarNew = toDouble(lebar)
            val tinggiNew = toDouble(tinggi)

            if(panjangNew == null){
                invalidDouble = true
                lengthEt.error = "Input tidak valid !"
            }

            if(lebarNew == null){
                invalidDouble = true
                widthEt.error = "Input tidak valid !"
            }

            if(tinggiNew == null){
                invalidDouble = true
                heightEt.error = "Input tidak valid !"
            }

            if(!invalidDouble && !empty){
                val volume = panjangNew as Double * tinggiNew as Double * lebarNew as Double

                resTv.text = volume.toString()
            }
        }
    }

    private fun toDouble(str: String): Double? {
        return try {
            str.toDouble()
        } catch (e: NumberFormatException) {
            null
        }
    }

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(STATE_RESULT, resTv.text.toString())
    }
}
