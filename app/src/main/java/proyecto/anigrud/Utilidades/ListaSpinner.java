package proyecto.anigrud.Utilidades;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaSpinner{
 private static ArrayList<String> datos;

   private static void cargaDatos(){

        datos = new ArrayList<>();
        datos.add("Mamífero");
        datos.add("Ave");
        datos.add("Reptil");
        datos.add("Anfibio");
        datos.add("Agnato");

    }

    public static ArrayList<String> getDatos() {
        if(datos ==null){
            cargaDatos();
        }
        return datos;
    }

    public static void agregarDato(String s){
       if(s!=null){
           datos.add(s);
       }
    }

    public static void borrarDato(int i){
       datos.remove(i);
    }



}
