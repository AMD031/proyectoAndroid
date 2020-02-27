package proyecto.anigrud.interfaces;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import proyecto.anigrud.models.Animal;

public interface FormInterface {


    public interface View{
        void finalizaViewAnimal();
        void errorFecha(boolean correcto, TextView tv);
        void errorCampo(boolean correcto, TextView tv);
        void requestPermission();
        void lanzarSnackbar();
        void abrirGaleria();
        void okCancelT();
        void lanzarEliminado();
        void errorGuardado();
        void existoGuardado();
        void ocultarMostarbtnEliminar(boolean mostar);
        void recuperDatosAnimal(Animal animal);

        void lanzarAyuda();
    }

    public interface Presenter
     {
        void onClickSave(Animal animal, boolean valido);
        void checkDate(String fecha, TextView tv);
        void checkField(TextView campoFormulario, TextView campoError);
        void onclickImagen(Context myContext);
        void resultPermission(int result);
        void mostarOkCancelT();
        void clicSiElimnar(Integer id);
        void errorSegundaVerificacion(boolean correcto, TextView tv);
         void ocultarMostarbtnEliminar(boolean mostarbtnEliminar);
         void recuperarDatos(int id);
         void updateAnimal(Animal animalDatos, boolean valido);
         ArrayList<String> ObtenerTipos();
         void borrarTipo(int indice);
         void agregarTipo(String m_text);
         void borrarArrayTipos();

         void mostrasAyuda();
     }


}
