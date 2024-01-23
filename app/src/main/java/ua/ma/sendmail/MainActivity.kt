package ua.ma.sendmail

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sendMessage:Button = findViewById(R.id.SendEmail);
        sendMessage.setOnClickListener{
            sendEmail();
        }
    }

    fun sendEmail(){

        val mailAddres:TextView = findViewById(R.id.Email)
        val mailTitle:TextView = findViewById(R.id.Title)
        val mailMessage:TextView = findViewById(R.id.Message)

        if(!mailAddres.text.isEmpty() && !mailTitle.text.isEmpty() && !mailMessage.text.isEmpty()){

            var intent = Intent(Intent.ACTION_SEND)

            intent.data = Uri.parse("Email")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(mailAddres.text))
            intent.putExtra(Intent.EXTRA_SUBJECT, mailTitle.text)
            intent.putExtra(Intent.EXTRA_TEXT, mailMessage.text)
            intent.type = "message/rfc822"

            var chooser = Intent.createChooser(intent, "Send Email")
            startActivity(chooser)

        }else{
            Toast.makeText(applicationContext, "Fill complete information", Toast.LENGTH_SHORT).show()
        }

    }
}