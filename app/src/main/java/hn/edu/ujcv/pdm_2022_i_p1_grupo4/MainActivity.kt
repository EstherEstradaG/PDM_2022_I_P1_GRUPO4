package hn.edu.ujcv.pdm_2022_i_p1_grupo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Pantalla Libros
        val btnL =findViewById<Button>(R.id.btn_L)


        btnL.setOnClickListener {
            val intent: Intent = Intent(this, Libros::class.java)
            startActivity(intent)
        }


        //Pantalla Alumnos

        val btnA = findViewById<Button>(R.id.btn_A)

        btnA.setOnClickListener {
            val intent: Intent = Intent(this, Alumnos::class.java)
            startActivity(intent)
        }


        // Pantalla Prestamos

        val btnP = findViewById<Button>(R.id.btn_P)

        btnP.setOnClickListener {
            val intent: Intent = Intent(this, Prestamos::class.java)
            startActivity(intent)
        }




    }
}