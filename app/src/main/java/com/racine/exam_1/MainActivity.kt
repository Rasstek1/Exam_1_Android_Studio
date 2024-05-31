package com.racine.exam_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Assurez-vous que le fichier de layout existe

        // Référence au bouton dans activity_main.xml
        val buttonNavigate: Button = findViewById(R.id.btn_naviguer)
        buttonNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        // Afficher un Toast au clic long
        buttonNavigate.setOnLongClickListener {
            Toast.makeText(this, "Navigating to Second Activity", Toast.LENGTH_SHORT).show()
            true
        }
    }
}