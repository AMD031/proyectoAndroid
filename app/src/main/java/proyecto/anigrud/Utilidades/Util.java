package proyecto.anigrud.Utilidades;

import java.util.ArrayList;

public class Util {
    public static boolean comprobarSiExiste(ArrayList<String>tipos, String valor){
        boolean encontrado = false;
        for(int i =0; i<tipos.size() && !encontrado ;i++){
            if(tipos.get(i).equals(valor)){
                encontrado = true;
            }
        }
        return  encontrado;
    }



}
