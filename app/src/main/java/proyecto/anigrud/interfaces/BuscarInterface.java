package proyecto.anigrud.interfaces;

import android.widget.TextView;

import java.util.ArrayList;

public interface BuscarInterface {

    public interface View{
        void lanzarGuardado();
        void errorFecha(boolean error, TextView tv);
    }

    public interface Presenter
    { void onClickSave();

        void checkDate(String fecha, TextView tv);

        ArrayList <String> ObtenerTipos();
    }


}