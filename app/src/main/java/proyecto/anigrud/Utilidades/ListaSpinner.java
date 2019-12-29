package proyecto.anigrud.Utilidades;

import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListaSpinner extends AppCompatActivity {

 private static ArrayList<String> datos;
   private static void cargaDatos(){
        datos = new ArrayList<>();

        datos.add("Mamífero");
        datos.add("Ave");
        datos.add("Reptil");
        datos.add("Agnato");
        datos.add("Anfibio");



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


   public static int getIndex(Spinner spinner, String myString){
        int index = 0;
        boolean encontrado = false;
        for (int i=0;i<spinner.getCount() && !encontrado;i++){
            if (spinner.getItemAtPosition(i).equals(myString)){
                index = i;
                encontrado = true;

            }
        }
        return index;
    }


}
