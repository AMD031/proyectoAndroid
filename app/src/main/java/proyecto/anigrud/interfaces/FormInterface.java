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
    }

    public interface Presenter
     {
        void onClickSave(Animal animal, boolean valido);
        void checkDate(String fecha, TextView tv);
        void checkField(TextView campoFormulario, TextView campoError);
        void onclickImagen(Context myContext);
        void resultPermission(int result);
        void mostarOkCancelT();
        void clicSiElimnar();
        void errorSegundaVerificacion(boolean correcto, TextView tv);

     }


}
