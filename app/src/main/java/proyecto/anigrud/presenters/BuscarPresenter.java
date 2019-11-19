package proyecto.anigrud.presenters;

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
}
