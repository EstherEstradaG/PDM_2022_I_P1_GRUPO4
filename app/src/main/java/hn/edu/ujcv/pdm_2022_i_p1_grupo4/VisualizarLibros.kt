package hn.edu.ujcv.pdm_2022_i_p1_grupo4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_visualizar_libros.*
import java.lang.reflect.Array.set
import java.util.regex.Pattern
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class VisualizarLibros : AppCompatActivity() {

    var valores: HashMap<Int,String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_visualizar_libros)

        btnBuscar.setOnClickListener { inicializar() }
    }

    private fun inicializar() {
        var intent = intent
        valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
            var nombreLibro = ""
            var Autor = ""
            var Fecha = ""
            var Editorial = ""


        for (valor in valores){
            val lista = valor.toString().split("|").toTypedArray()

            nombreLibro = lista[1].toString()
            Autor = lista[2].toString()
            Fecha = lista[3].toString()
            Editorial = lista[4].toString()
        }

        txvNombreL.setText(nombreLibro)
        txvA.setText(Autor)
        txvF.setText(Fecha)
        txvEdi.setText(Editorial)
    }
}