package com.example.qr_generator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import com.google.zxing.WriterException

class MainActivity : AppCompatActivity() {
    var iView: ImageView? = null
    var gButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iView = findViewById(R.id.imageView)
        gButton = findViewById(R.id.button)
        gButton?.setOnClickListener {
            generateQRCode("https://www.youtube.com/watch?v=pQ1KYUJpCGU&ab_channel=NecoRu")

        }
    }
    private fun generateQRCode(text: String){
        var qrGenerator = QRGEncoder(text, null, QRGContents.Type.TEXT, 600)
        try {
           var bMap = qrGenerator.encodeAsBitmap()
            iView?.setImageBitmap(bMap)

        }catch (e: WriterException){

        }
    }
}