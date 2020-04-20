package jp.freebit.getadvertisingid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.adidText)

        GlobalScope.launch {
            val adid = AdvertisingIdClient.getAdvertisingIdInfo(applicationContext).id
            Log.e("MainActivity","ADID="+adid)
            withContext(Dispatchers.Main){
                text.setText(adid)
            }
        }
    }
}
