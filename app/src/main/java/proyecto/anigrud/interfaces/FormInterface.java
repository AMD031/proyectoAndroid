package proyecto.anigrud.interfaces;

import android.widget.TextView;

public interface FormInterface {


    public interface View{
        void lanzarGuardado();
        void errorFecha(boolean correto, TextView tv);
        void errorCampo(boolean correcto, TextView tv);
    }

    public interface Presenter
     {
        void onClickSave();
        void checkDate(String fecha, TextView tv);
        void checkField(TextView campoFormulario, TextView campoError);
     }


}
