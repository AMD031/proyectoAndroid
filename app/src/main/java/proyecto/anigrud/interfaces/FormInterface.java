package proyecto.anigrud.interfaces;

public interface FormInterface {


    public interface View{

        void lanzarGuardado();
    }

    public interface Presenter
    {
        void onClickSave();

    }


}
