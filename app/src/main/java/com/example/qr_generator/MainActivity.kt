package com.example.qr_generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {
    var iView: ImageView? = null
    var gButton: Button? = null
    var eText: EditText? = null
    var inputvalue: String? = null
    var tag = "GenerateQrCode"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iView = findViewById(R.id.imageView)
        gButton = findViewById(R.id.button)
        eText = findViewById(R.id.editText)

        gButton?.setOnClickListener {
            inputvalue = eText!!.text.toString().trim { it <= ' ' }
            generateQRCode()
        }
    }

    private fun generateQRCode() {
        if (inputvalue!!.isNotEmpty()) {
            val qrGenerator = QRGEncoder(inputvalue, null, QRGContents.Type.TEXT, 600)
            try {
                val bitmap = qrGenerator.encodeAsBitmap()
                iView?.setImageBitmap(bitmap)

            } catch (e: WriterException) {
                Log.v(tag, e.toString())
            }
        } else {
            eText!!.error = "Введите текст"
        }
    }
}