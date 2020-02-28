package proyecto.anigrud.presenters;

import proyecto.anigrud.interfaces.AyudaInterface;

public class AyudaPresenter  implements AyudaInterface.Presenter{

    private static AyudaInterface.View view;
    public static void ErrorConexion() {
        view.mostrarErrorConexion();
    }
}
