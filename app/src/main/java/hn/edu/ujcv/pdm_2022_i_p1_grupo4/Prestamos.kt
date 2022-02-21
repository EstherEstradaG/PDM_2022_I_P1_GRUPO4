package hn.edu.ujcv.pdm_2022_i_p1_grupo4

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_prestamos.*
import java.util.*

class Prestamos : AppCompatActivity() {

    var dt: String = ""
    var mes: String = ""
    var contador = 1
    var valores: HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestamos)

        txv_NumPrestamo.setText(contador.toString())
        btn_MostrarPrestamo.setOnClickListener { Mostrar() }
        btn_GuardarPrestamo.setOnClickListener { Guardar() }


    }

    private fun Mostrar() {
        val intent: Intent = Intent(this, MostrarPrestamos::class.java)
        intent.putExtra("valores",valores)
        startActivity(intent)
    }



    fun openDateTimePicker(view: android.view.View) {

        var c: Calendar = Calendar.getInstance()
        var fd:Calendar = Calendar.getInstance()

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { datePicker, yy, mm, dd ->
             mes = Mes(mm+1)
             dt = "$dd/$mes/$yy"
             fd.set(yy,mm,dd)
             fd.add(Calendar.DAY_OF_YEAR,3)
             var df = fd.time.toString().substring(8,10)+"/"+fd.time.toString().substring(4,7)+"/"+fd.time.toString().substring(24,28)
            txv_FechaDevolucion.setText(df)

             txv_FechaPrestamo.setText(dt)
        }, c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()


    }

    fun Guardar(){


        if (txt_NumCuenta.text.toString().length != 10){
            txt_NumCuenta.error ="El número de cuenta debe de contener 10 dígitos"
        }else if(txt_NumLibro.text.toString().length != 8){
            txt_NumLibro.error ="El número del libro debe de contener 8 dígitos"
        }else if(txv_FechaPrestamo.text.toString().length < 1 || txv_FechaDevolucion.text.toString().length < 1 ){
            txv_FechaPrestamo.error ="Debe de seleccionar una fecha"
        }else{
            val dato = StringBuilder()
            contador+=1

            dato.append(txt_NumCuenta.text.toString().trim()).append("|")
            dato.append(txv_NumPrestamo.text.toString()).append("|")
            dato.append(txt_NumLibro.text.toString().trim()).append("|")
            dato.append(txv_FechaPrestamo.text.toString().trim()).append("|")
            dato.append(txv_FechaDevolucion.text.toString().trim())
            valores.put(contador,dato.toString())

            btn_MostrarPrestamo.isEnabled = true
            Toast.makeText(this, "Se guardó correctamente", Toast.LENGTH_SHORT).show()

            txv_NumPrestamo.setText(contador.toString())
            Limpiar()
        }


    }

    fun Limpiar(){
        txt_NumCuenta.setText("")
        txt_NumLibro.setText("")
        txv_FechaDevolucion.setText("")
        txv_FechaPrestamo.setText("")
    }

    fun Mes(mes:Int):String{

        if(mes == 1) {
            return "Jan"
        }else if (mes == 2){
            return "Feb"
        }else if (mes == 3){
            return "Mar"
        }else if (mes == 4){
            return "Apr"
        }else if (mes == 5){
            return "May"
        }else if (mes == 6){
            return "Jun"
        }else if (mes == 7){
            return "Jul"
        }else if (mes == 8){
            return "Aug"
        }else if (mes == 9){
            return "Sep"
        }else if (mes == 10){
            return "Oct"
        }else if (mes == 11){
            return "Nov"
        }else{
            return "Dec"
        }



    }

}