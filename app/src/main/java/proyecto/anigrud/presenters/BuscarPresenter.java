package proyecto.anigrud.presenters;

import android.widget.TextView;

import java.util.ArrayList;

import proyecto.anigrud.Utilidades.Validar;
import proyecto.anigrud.interfaces.BuscarInterface;
import proyecto.anigrud.models.AnimalModelo;

public class BuscarPresenter implements BuscarInterface.Presenter {


    private BuscarInterface.View view;

    public BuscarPresenter(BuscarInterface.View view) {
        this.view = view;
      }

    @Override
    public void onClickSave() {
        view.lanzarGuardado();
    }

    @Override
    public void checkDate(String fecha, TextView tv) {
       view.errorFecha(Validar.validarFecha(fecha),tv);
    }

    @Override
    public ArrayList<String> ObtenerTipos() {
        ArrayList <String> tipos = AnimalModelo.getInstance().getTipos();
        return tipos;
    }


}
