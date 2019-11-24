package proyecto.anigrud.presenters;

import android.widget.TextView;

import proyecto.anigrud.Utilidades.Validar;
import proyecto.anigrud.interfaces.BuscarInterface;

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




}
