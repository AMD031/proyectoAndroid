package proyecto.anigrud.interfaces;

public interface BuscarInterface {

    public interface View{
        void lanzarGuardado();
    }

    public interface Presenter
    {
        void onClickSave();
    }


}