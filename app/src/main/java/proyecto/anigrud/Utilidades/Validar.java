package proyecto.anigrud.Utilidades;

import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean contineNumero(String s){
        boolean continene = false;
        Pattern  p= Pattern.compile("[1-9]+");
        Matcher m=p.matcher(s);
        if(m.find()){
            continene = true;
        }
        return continene;
    }




    public static boolean ceroUno(Integer n){
        boolean valido = false;
        if(n ==0 || n ==1){
            valido = true;
        }
        return  valido;
    }

    public static boolean comprobarString(String string){
        boolean valido = false;
        if(string !=null && !string.isEmpty() && !string.equals("") ){
            valido =  true;
        }
        return valido;
    }


    public static boolean compruebaCampo(TextView tv) {
       boolean correcto = false;
        if(!tv.getText().toString().isEmpty()){
            correcto = true;
        }
        return correcto;
    }
}
