package hn.edu.ujcv.pdm_2022_i_p1_grupo4

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_mostrar_prestamos.*
import kotlinx.android.synthetic.main.activity_prestamos.*

class MostrarPrestamos : AppCompatActivity() {

    var valores: HashMap<Int,String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_prestamos)
        inicializar()
        btn_BuscarPrestamo.setOnClickListener { Buscar() }
    }

    private fun Buscar() {
        var numPrestamo:String
        var numCuenta:String
        var numLibro:String
        var fechaPrestamo:String
        var fechaDevolucion:String
        limpiar()

        for(valor in valores) {

            val lista = valor.toString().split("|","=")

            numPrestamo = lista[2]
            numCuenta = lista[1]
            numLibro = lista[3]
            fechaPrestamo = lista[4]
            fechaDevolucion = lista[5]

            if (txt_BuscarPrestamo.text.toString().equals(numCuenta)) {
                txt_MostrarCuenta.setText(numCuenta)
                txt_MostrarPrestamo.setText(numPrestamo)
                txt_MostrarLibro.setText(numLibro)
                txt_MostrarFechaPrestamo.setText(fechaPrestamo)
                txt_MostrarFechaDevolucion.setText(fechaDevolucion)
                return
            }

        }

    }

    fun limpiar(){
        txt_MostrarCuenta.setText("")
        txt_MostrarFechaPrestamo.setText("")
        txt_MostrarLibro.setText("")
        txt_MostrarFechaPrestamo.setText("")
        txt_MostrarFechaDevolucion.setText("")


    }

    private fun inicializar() {
            var intent = intent
            valores = intent.getSerializableExtra("valores") as HashMap<Int, String>
    }
}