package proyecto.anigrud.interfaces;

import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import proyecto.anigrud.models.Animal;

public interface FormInterface {


    public interface View{
        void lanzarGuardado();
        void errorFecha(boolean correto, TextView tv);
        void errorCampo(boolean correcto, TextView tv);
        void requestPermission();
        void lanzarSnackbar();

    }

    public interface Presenter
     {
        void onClickSave();
        void checkDate(String fecha, TextView tv);
        void checkField(TextView campoFormulario, TextView campoError);
        void onclickImagen(Context myContext);
        void resultPermission(int result);
     }


}
