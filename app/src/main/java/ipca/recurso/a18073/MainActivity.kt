package ipca.recurso.a18073

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btn :Button = findViewById(R.id.btnPassword)
        btn.setOnClickListener{
            val intent = Intent(this, Password_activity::class.java)
            startActivity(intent)
        }
    }
}