package proyecto.anigrud.interfaces;

public interface ListadoInterface {
    public interface View{

      void lanzarFormulario();
      void lanzarSobre();

    }

    public interface Presenter
    {
        void onClickAbout();
        void onClickAdd();
    }

}
