package proyecto.anigrud.interfaces;

import java.util.ArrayList;

import proyecto.anigrud.models.Animal;

public interface ListadoInterface {
    public interface View{

      void lanzarFormulario(int id);
      void lanzarSobre();
      void lanzarBuscar();



    }

    public interface Presenter
    {
        void onClickAbout();
        void onClickAdd();
        void onClicckSearch();
        void onClickRecyclerView(int id);
        ArrayList<Animal> getAllAnimal();
    }

}
