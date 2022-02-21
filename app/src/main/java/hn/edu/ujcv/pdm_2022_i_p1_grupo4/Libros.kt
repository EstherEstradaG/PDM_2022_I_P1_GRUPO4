package hn.edu.ujcv.pdm_2022_i_p1_grupo4


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_libros.*
import java.lang.StringBuilder




class Libros : AppCompatActivity() {

    var numero = 0
    var valores: HashMap<Int,String> = hashMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libros)

        inicializar()

        btnGuardar.setOnClickListener { guardar() }
        btnEnviar.setOnClickListener { enviar() }

    }

    private fun enviar() {

        val intent = Intent(this,VisualizarLibros::class.java)
        intent.putExtra("valores", valores)
        startActivity(intent)
    }



    private fun guardar() {
        val dato = StringBuilder()
        numero = 0

        if (txtIdLibro.text.isEmpty()||txtNombreLibro.text.isEmpty()||txtAutor.text.isEmpty()||txtFecha.text.isEmpty()||txtEditorial.text.isEmpty()){
            Toast.makeText(this, "Campos vacios!!!", Toast.LENGTH_SHORT).show()
        }else {
            dato.append(txtIdLibro.text.toString().trim()).append("|")
            dato.append(txtNombreLibro.text.toString().trim()).append("|")
            dato.append(txtAutor.text.toString().trim()).append("|")
            dato.append(txtFecha.text.toString().trim()).append("|")
            dato.append(txtEditorial.text.toString().trim()).append("|")
            valores.put(numero, dato.toString())
            btnEnviar.isEnabled = true
        }

    }

    private fun inicializar() {

        btnEnviar.isEnabled= false
    }
}