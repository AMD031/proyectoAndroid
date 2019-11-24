package proyecto.anigrud.Utilidades;

import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Validar {


    public static boolean validarFecha(String fecha) {
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }


    public static boolean compruebaCampo(TextView tv) {
       boolean correcto = false;
        if(!tv.getText().toString().isEmpty()){
            correcto = true;
        }
        return correcto;
    }
}
